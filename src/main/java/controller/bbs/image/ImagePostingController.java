/*
========================================================================
파    일    명 : ImagePostingController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : 사진 자랑 게시물 작성 페이지로 이동, 업로드하는 컨트롤러
========================================================================
*/
package controller.bbs.image;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.ImageNotExistException;
import petProject.exception.ImagePostingException;
import petProject.service.ImageSelectService;
import petProject.service.bbs.image.ImagePostingService;
import petProject.vo.Image;
import petProject.vo.request.ImagePostingRequest;

@Controller
@RequestMapping("/posting/img")
public class ImagePostingController {
	@Resource(name = "imageSelectService")
	ImageSelectService imageSelectService;

	@Resource(name = "imagePostingService")
	ImagePostingService imagePostingService;

	// 반려견 자랑 게시물을 작성하는 페이지로 이동시키는 메소드
	@GetMapping
	public String getImagePosting(@ModelAttribute("imagePostingRequest") ImagePostingRequest imagePostingRequest,
			HttpServletRequest request, HttpSession session, Model model) {
		try {
			Image image = imageSelectService.selectImage(imagePostingRequest.getImageNumber());
			// 미리 보기 이미지를 보여주기 위해 model에 넣어줌
			model.addAttribute("image", image);
			model.addAttribute("petRegistrationNumber", imagePostingRequest.getPetRegistrationNumber());
			return "bbs/img/posting";
		} catch (ImageNotExistException e) {
			e.printStackTrace();
			// 존재하지 않는 이미지 입니다.
			return "redirect:/pet/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/pet/list";
		}

	}

	// 반려견 자랑 게시물 작성 시 동작함
	@PostMapping
	public String postImagePosting(
			@Valid @ModelAttribute("imagePostingRequest") ImagePostingRequest imagePostingRequest, Errors errors,
			HttpServletRequest request, HttpSession session, Model model) {
		try {
			if (errors.hasErrors()) {
				// 미리 보기 이미지를 보여주기 위해 model에 넣어줌
				Image image = imageSelectService.selectImage(imagePostingRequest.getImageNumber());
				model.addAttribute("image", image);
				model.addAttribute("petRegistrationNumber", imagePostingRequest.getPetRegistrationNumber());
				return "bbs/img/posting";
			}
			imagePostingService.postingImage(imagePostingRequest);

			return "redirect:/pet/list";
		} catch (ImagePostingException e) {
			e.printStackTrace();
			errors.reject("failed.posting.img");
			return "redirect:/pet/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/pet/list";
		}

	}
}
