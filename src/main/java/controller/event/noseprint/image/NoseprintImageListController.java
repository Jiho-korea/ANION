/*
========================================================================
파    일    명 : NoseprintImageListController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 리스트, 업로드 매핑 메소드 있음
========================================================================
*/
package controller.event.noseprint.image;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import controller.image.ImageListController;
import petProject.service.ScriptWriter;
import petProject.service.event.noseprint.NoseprintImageListService;
import petProject.service.event.noseprint.NoseprintImageUploadService;
import petProject.service.pet.PetInfoService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.NoseprintImage;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/info/list")
public class NoseprintImageListController {

	@Resource(name = "noseprintImageUploadService")
	NoseprintImageUploadService noseprintImageUploadService;

	@Resource(name = "noseprintImageListService")
	NoseprintImageListService noseprintImageListService;

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/npimage")
	public String listNoseprintImage(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			@CookieValue(value = "checkEventGuidance", required = false) Cookie cookie_check_event_guidance,
			RedirectAttributes redirect, HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			List<NoseprintImage> noseprintImageList = noseprintImageListService
					.selectNoseprintImageList(petRegistrationNumber);

			// (반려견 이름)의 비문리스트
			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);
			// System.out.println(imageList.isEmpty());

			if (noseprintImageList.isEmpty()) {
				if (cookie_check_event_guidance == null) {
					redirect.addFlashAttribute("first", petRegistrationNumber);
					return "redirect:/guidance/npevent";
				} else {
					Cookie cookie_delete_check_event_guidance = new Cookie("checkEventGuidance",
							cookie_check_event_guidance.getValue());
					cookie_delete_check_event_guidance.setPath("/");
					cookie_delete_check_event_guidance.setMaxAge(0);
					response.addCookie(cookie_delete_check_event_guidance);
				}

			}
			model.addAttribute("noseprintImageList", noseprintImageList);
			model.addAttribute("petRegistrationNumber", petRegistrationNumber);
			return "event/noseprint/pet/image/noseprintImageList";
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("bug"), "home", request, response);
			return null;
		}

	}

	@PostMapping("/npimage")
	public String listNoseprintImageInsert(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			@RequestParam(value = "delete", required = false) String deleteButton, HttpSession session,
			RedirectAttributes redirect, MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (deleteButton != null) {
			redirect.addFlashAttribute("delete", 1);
			return "redirect:/info/list/npimage?petRegistrationNumber=" + petRegistrationNumber;
		} else {
			try {
				AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

				List<MultipartFile> file = request.getFiles("file");
				// logger.info("originalName: " + file.getOriginalFilename());
				// logger.info("size: " + file.getSize());
				// logger.info("contentType: " + file.getContentType());

				String rootPath = request.getSession().getServletContext().getRealPath("/upload/noseprint");

				noseprintImageUploadService.uploadNoseprintImage(authInfo.getMemberNumber(), file, rootPath,
						petRegistrationNumber);

				return "redirect:/info/list/npimage?petRegistrationNumber=" + petRegistrationNumber;

			} catch (IOException e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"info/list/npimage?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"info/list/npimage?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			}
		}
	}
}