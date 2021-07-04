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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import petProject.vo.AuthInfo;
import petProject.vo.dto.NoseprintImage;

@Controller
@RequestMapping("/info/list")
public class NoseprintImageListController {

	@Resource(name = "noseprintImageUploadService")
	NoseprintImageUploadService noseprintImageUploadService;

	@Resource(name = "noseprintImageListService")
	NoseprintImageListService noseprintImageListService;

	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/npimage")
	public String listNoseprintImage(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model) {

		try {
			List<NoseprintImage> noseprintImageList = noseprintImageListService
					.selectNoseprintImageList(petRegistrationNumber);
			// System.out.println(imageList.isEmpty());
			model.addAttribute("noseprintImageList", noseprintImageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return "event/noseprint/pet/image/noseprintImageList"; // 변경
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

				noseprintImageUploadService.uploadNoseprintImage(authInfo, file, rootPath, petRegistrationNumber);

				return "redirect:/info/list/npimage?petRegistrationNumber=" + petRegistrationNumber;

			} catch (IOException e) {
				e.printStackTrace();
				ScriptWriter.write("이미지 업로드에 실패하였습니다.",
						"info/list/npimage?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				ScriptWriter.write("이미지 업로드에 실패하였습니다.",
						"info/list/npimage?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			}
		}
	}
}