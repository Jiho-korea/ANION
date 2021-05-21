/*
========================================================================
파    일    명 : ImageDeleteController.java
========================================================================
작    성    자 : 임원석,정세진
작    성    일 : 2020.02.02
작  성  내  용 : 사진 다중 삭제 기능 구현
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.20
수  정  내  용 : 사진 삭제 시 체크된 사진이 있는 지 검사하는 코드 추가
========================================================================
*/
package controller.image;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import petProject.service.ScriptWriter;
import petProject.service.image.ImageDeleteService;
import petProject.service.image.ImageListService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Image;

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
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect, Model model)
			throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/upload");
		try {
			for (int i = 0; i < paths_id.length; i++) {
				imageDeleteService.deleteImage(paths_id[i]);
				File deleteFile = new File(rootPath + "/" + paths_id[i]);
				deleteFile.delete();
			}
			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;

		} catch (NullPointerException e) {
			// e.printStackTrace();
			ScriptWriter.write("삭제할 사진을 선택해 주세요.", "info/list/image?petRegistrationNumber=" + petRegistrationNumber,
					request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/info/list/image?petRegistrationNumber=" + petRegistrationNumber;
		}
	}

}