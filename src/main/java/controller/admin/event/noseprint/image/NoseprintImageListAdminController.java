/*
========================================================================
파    일    명 : NoseprintImageListAdminController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.18
작  성  내  용 : 관리자의 회원 비문 이미지 조회 컨트롤러
========================================================================

*/
package controller.admin.event.noseprint.image;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import controller.image.ImageListController;
import petProject.service.ScriptWriter;
import petProject.service.admin.member.MemberSelectService;
import petProject.service.event.noseprint.NoseprintImageListService;
import petProject.service.event.noseprint.NoseprintImageUploadService;
import petProject.service.pet.PetInfoService;
import petProject.vo.dto.Member;
import petProject.vo.dto.NoseprintImage;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/admin/pet/image/npevent")
public class NoseprintImageListAdminController {

	@Resource(name = "noseprintImageUploadService")
	NoseprintImageUploadService noseprintImageUploadService;

	@Resource(name = "noseprintImageListService")
	NoseprintImageListService noseprintImageListService;

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Resource(name = "memberSelectService")
	MemberSelectService memberSelectService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/{memberNumber}")
	public String listImageAdmin(@PathVariable("memberNumber") int memberNumber,
			@RequestParam(value = "petRegistrationNumber", required = false) Integer petRegistrationNumber,
			HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// url로 접근 시 petRegistrationNumber 파라미터를 주지 않았을 때
		if (petRegistrationNumber == null) {
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "admin/pet/npevent/" + memberNumber, request, response);
			return null;
		}

		// System.out.println("memberId = " + authInfo.getMemberId() +
		// "\npetRegistrationNumber = " + petRegistrationNumber);
		try {
			List<NoseprintImage> noseprintImageList = noseprintImageListService
					.selectNoseprintImageList(petRegistrationNumber);
			// System.out.println(imageList.isEmpty());

			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);

			// 회원 조회
			Member member = memberSelectService.selectMemberByMemberNumber(memberNumber);
			model.addAttribute("admin", true);
			model.addAttribute("pet", pet);
			model.addAttribute("member", member);
			model.addAttribute("noseprintImageList", noseprintImageList);

			return "event/noseprint/pet/image/noseprintImageList";
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("bug"), "home", request, response);
			return null;
		}

	}

	@PostMapping("/{memberNumber}")
	public String listImageInsert(@PathVariable("memberNumber") int memberNumber,
			@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
			@RequestParam(value = "delete", required = false) String deleteButton, HttpSession session,
			RedirectAttributes redirect, MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (deleteButton != null) {
			redirect.addFlashAttribute("delete", 1);
			return "redirect:/admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber="
					+ petRegistrationNumber;
		} else {
			try {

				List<MultipartFile> file = request.getFiles("file");
				// logger.info("originalName: " + file.getOriginalFilename());
				// logger.info("size: " + file.getSize());
				// logger.info("contentType: " + file.getContentType());

				String rootPath = request.getSession().getServletContext().getRealPath("/upload/noseprint");
				noseprintImageUploadService.uploadNoseprintImage(memberNumber, file, rootPath, petRegistrationNumber);
				return "redirect:/admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber="
						+ petRegistrationNumber;

			} catch (IOException e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber=" + petRegistrationNumber,
						request, response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"admin/pet/image/npevent/" + memberNumber + "?petRegistrationNumber=" + petRegistrationNumber,
						request, response);
				return null;
			}
		}

	}
}