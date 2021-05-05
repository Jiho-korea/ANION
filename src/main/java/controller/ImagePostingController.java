/*
========================================================================
파    일    명 : ImagePostingController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : 사진 자랑 게시물 작성 페이지로 이동, 업로드하는 컨트롤러
========================================================================
*/
package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.ImageNotExistException;
import petProject.service.ImageSelectService;
import petProject.vo.Image;
import petProject.vo.ImagePostingRequest;

@Controller
@RequestMapping("/posting/img")
public class ImagePostingController {
	@Resource(name = "imageSelectService")
	ImageSelectService imageSelectService;

	@GetMapping
	public String getImagePosting(@ModelAttribute("imagePostingRequest") ImagePostingRequest imagePostingRequest,
			HttpServletRequest request, HttpSession session, Model model) {
		try {
			Image image = imageSelectService.selectImage(imagePostingRequest.getImageNumber());
			model.addAttribute("image", image);

			return "post/posting_img";
		} catch (ImageNotExistException e) {
			e.printStackTrace();
			// 존재하지 않는 이미지 입니다.
			return "redirect:/pet/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/pet/list";
		}

	}

}
