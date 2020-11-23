/*
========================================================================
파    일    명 : PetInfoController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 컨트롤러
========================================================================
*/

package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.PetNotFoundException;
import petProject.service.PetInfoService;
import petProject.vo.Pet;

@Controller
@RequestMapping("/info/pet")
public class PetInfoController {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	public PetInfoController() {
		super();
	}

	@GetMapping
	public String petInfo(@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			Model model) {
		try {
			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);
			return "info/pet";
		} catch (PetNotFoundException e) {
			return "main/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/list";
		}

	}
	
//	@PostMapping
//	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
//			HttpServletResponse response) {
//		if (errors.hasErrors()) {
//			return "login/loginFormPage";
//		}
//
//		try {
//			Member member = loginService.selectByIdPassword(loginRequest);
//
//			session.setAttribute("login", member);
//
//			Cookie memoryCookie = new Cookie("memory", loginRequest.getId());
//			memoryCookie.setPath("/");
//			if (loginRequest.isMemory()) {
//				memoryCookie.setMaxAge(60 * 60 * 24 * 30);
//			} else {
//				memoryCookie.setMaxAge(0);
//			}
//			response.addCookie(memoryCookie);
//
//			return "redirect:/home";
//		} catch (MemberNotFoundException e) {
//			errors.reject("notfound");
//			return "login/loginFormPage";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "login/loginFormPage";
//		}
//	}

}
