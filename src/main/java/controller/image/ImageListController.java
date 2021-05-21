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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import petProject.service.image.ImageListService;
import petProject.service.image.ImageUploadService;
import petProject.vo.AuthInfo;
import petProject.vo.Image;
import petProject.vo.ImageUploadRequest;

@Controller
@RequestMapping("/info/list")
public class ImageListController {

	@Resource(name = "imageUploadService")
	ImageUploadService imageUploadService;

	@Resource(name = "imageListService")
	ImageListService imageListService;

	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/image")
	public String listImage(@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		// System.out.println("memberId = " + authInfo.getMemberId() +
		// "\npetRegistrationNumber = " + petRegistrationNumber);
		try {
			List<Image> imageList = imageListService.selectImageList(petRegistrationNumber);
			// System.out.println(imageList.isEmpty());
			model.addAttribute("imageList", imageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		return "/list/image";
	}

	@PostMapping("/image")
	public String listImageInsert(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			@RequestParam(value = "delete", required = false) String deleteButton, HttpSession session,
			RedirectAttributes redirect, MultipartHttpServletRequest request) {

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

				String savedName;
				for (MultipartFile mf : file) {
					savedName = uploadFile(mf.getOriginalFilename(), mf.getBytes(), rootPath);

					// model.addAttribute("savedName", savedName);
					String absPath = rootPath + "\\" + savedName;
					System.out.println("absPath = " + absPath);

					ImageUploadRequest imageUploadRequest = new ImageUploadRequest(authInfo.getMemberNumber(),
							petRegistrationNumber, savedName);
					imageUploadService.insertImage(imageUploadRequest);
				}
				return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
			}
		}

	}

	private String uploadFile(String originalName, byte[] fileData, String rootPath) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rndName = sdf.format(new java.util.Date()) + System.currentTimeMillis();
		// UUID uid = UUID.randomUUID(); // uid.toString()
		String savedName = rndName + "." + originalName.substring(originalName.lastIndexOf(".") + 1);
		File target = new File(rootPath, savedName);
		// System.out.println(rootPath);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
}