/*
========================================================================
파    일    명 : ImageListController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 
========================================================================
수    정    자 : 임원석,정세진
수    정    일 : 2020.02.02
수  정  내  용 : 사진 다중 삭제 기능 구현
========================================================================
수    정    자 : 임원석
수    정    일 : 2020.02.03
수  정  내  용 : 사진 다중 업로드 기능 구현
========================================================================
=============================== 함  수  설  명  ===============================
listImage : 이미지 리스트 뽑아오는 함수
listImageInsert : 이미지 등록 함수
uploadFile : 이미지 업로드 형식 설정 함수
========================================================================
*/
package controller.image;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import petProject.exception.PetNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.image.ImageListService;
import petProject.service.image.ImageUploadService;
import petProject.service.pet.PetInfoService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Image;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/info/list")
public class ImageListController {

	@Resource(name = "imageUploadService")
	ImageUploadService imageUploadService;

	@Resource(name = "imageListService")
	ImageListService imageListService;

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/image")
	public String listImage(@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// System.out.println("memberId = " + authInfo.getMemberId() +
		// "\npetRegistrationNumber = " + petRegistrationNumber);
		try {
			List<Image> imageList = imageListService.selectImageList(petRegistrationNumber);
			// System.out.println(imageList.isEmpty());

			// (반려견 이름)의 갤러리
			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);
			model.addAttribute("imageList", imageList);
			return "pet/image/imageList";
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "home", request, response); // url로 아무 펫번호나 입력했을 때 여기서 걸림
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("bug"), "home", request, response);
			return null;
		}

	}

	@PostMapping("/image")
	public String listImageInsert(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			@RequestParam(value = "delete", required = false) String deleteButton, HttpSession session,
			RedirectAttributes redirect, MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (deleteButton != null) {
			redirect.addFlashAttribute("delete", 1);
			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
		} else {
			try {
				AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

				List<MultipartFile> file = request.getFiles("file");
				// logger.info("originalName: " + file.getOriginalFilename());
				// logger.info("size: " + file.getSize());
				// logger.info("contentType: " + file.getContentType());

				String rootPath = request.getSession().getServletContext().getRealPath("/upload");
				imageUploadService.uploadImage(authInfo.getMemberNumber(), file, rootPath, petRegistrationNumber);

				return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;

			} catch (IOException e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"info/list/image?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				ScriptWriter.write(messageSourceAccessor.getMessage("failed.posting.img"),
						"info/list/image?petRegistrationNumber=" + petRegistrationNumber, request, response);
				return null;
			}
		}

	}
}