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

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String ownerRegister(OwnerRegisterRequest ownerRegisterRequest) {
		return "register/signup";
	}

	@PostMapping("/step2")
	public String ownerRegister(@Valid OwnerRegisterRequest ownerRegisterRequest, Errors errors, Model model)
			throws Exception {
		if (errors.hasErrors()) {
			return "register/signup";
		}

		try {
			ownerRegisterService.insertOwner(ownerRegisterRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/login/login";
	}

	@RequestMapping("/step3")
	public String duplicate(OwnerRegisterRequest ownerRegisterRequest, Errors errors, Model model) throws Exception {
		if (ownerRegisterService.selectById(ownerRegisterRequest) != 0) {
			errors.reject("duplicate.ownerRegisterRequest");
			return "register/signup";
		} else if (ownerRegisterRequest.getOwnerId()=="") {
			errors.reject("NotBlank");
			return "register/signup";
		}
		errors.reject("notDuplicate");
		return "register/signup";
	}

}
