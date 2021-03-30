/*
========================================================================
파    일    명 : ImageDeleteController.java
========================================================================
작    성    자 : 임원석,정세진
작    성    일 : 2020.02.02
작  성  내  용 : 사진 다중 삭제 기능 구현
========================================================================
*/
package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.service.ImageDeleteService;
import petProject.service.ImageListService;
import petProject.vo.AuthInfo;
import petProject.vo.Image;

@Controller
@RequestMapping("/info/list")
public class ImageDeleteController {

	@Resource(name = "imageListService")
	ImageListService imageListService;

	@Resource(name = "imageDeleteService")
	ImageDeleteService imageDeleteService;

	private static final Logger logger = LoggerFactory.getLogger(ImageListController.class);

	@GetMapping("/imageDelete")
	public String listDeleteImage(
			@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

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

	@PostMapping("/imageDelete")
	public String listDeleteImage(
			@RequestParam(value = "petRegistrationNumber", required = false) int petRegistrationNumber,
			@RequestParam(value = "chBox", required = false) String[] paths_id, HttpSession session,
			HttpServletRequest request) throws IOException {
		String rootPath = request.getSession().getServletContext().getRealPath("/upload");
		try {
			for (int i = 0; i < paths_id.length; i++) {
				System.out.println(paths_id[i]);
				imageDeleteService.deleteImage(paths_id[i]);
				File deleteFile = new File(rootPath + "/" + paths_id[i]);
				deleteFile.delete();
			}
			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
		}
	}

}