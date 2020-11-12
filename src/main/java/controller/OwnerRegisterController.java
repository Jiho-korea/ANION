/*
========================================================================
파    일    명 : OwnerRegisterController.java
========================================================================
작    성    자 : 임원석, 정세진
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 컨트롤러 작성
========================================================================
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메서드 추가 
========================================================================

*/

package controller;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.OwnerInsertException;
import petProject.service.OwnerRegisterService;
import petProject.vo.OwnerRegisterRequest;

@Controller
@RequestMapping("/signup")
public class OwnerRegisterController {
	@Resource(name = "ownerRegisterService")
	OwnerRegisterService ownerRegisterService;

	public OwnerRegisterController() {
		super();
	}

	@RequestMapping("/step1")
	public String signStep1(OwnerRegisterRequest ownerRegisterRequest) {
		return "register/signup";
	}

	@GetMapping("/step2")
	public String signupStep2Get() {
		return "redirect:/register/signup";
	}

	@GetMapping("/check/duplicate")
	public String signupCheckDuplicateGet() {
		return "redirect:/register/signup";
	}

	@PostMapping("/step2")
	public String signStep2(@Valid OwnerRegisterRequest ownerRegisterRequest, Errors errors, Model model,
			@RequestParam(value = "dupCheck", defaultValue = "false") boolean dupCheck) throws Exception {
		if (!dupCheck) {
			errors.reject("no.duplicate.check.ownerRegisterRequest");
		} else {
			model.addAttribute("duplicate", !dupCheck);//
		}
		if (ownerRegisterRequest.getOwnerPhoneNumber().length() < 13
				&& !Pattern.matches("^[0-9]+$", ownerRegisterRequest.getOwnerPhoneNumber())) {
			errors.reject("no.number.check.ownerRegisterRequest");
		}
		if (errors.hasErrors()) {
			return "register/signup";
		}

		try {
			ownerRegisterService.insertOwner(ownerRegisterRequest);
		} catch (OwnerInsertException e) {
			errors.reject("failed.signup");
			return "register/signup";
		} catch (Exception e) {
			return "register/signup";
		}
		return "redirect:/login/login";
	}

	@PostMapping("/check/duplicate")
	public String checkDuplicate(@RequestParam(value = "ownerId", required = true) String ownerId,
			OwnerRegisterRequest ownerRegisterRequest, Errors errors, Model model) throws Exception {
		if ("".equals(ownerId)) {
			errors.rejectValue("ownerId", "blank");
		}

		if (errors.hasErrors()) {
			return "register/signup";
		}
		if (ownerRegisterService.selectById(ownerId) != 0) {
			errors.reject("duplicate.ownerRegisterRequest");
			return "register/signup";
		} else {
			model.addAttribute("duplicate", false);
		}
		return "register/signup";
	}

}
