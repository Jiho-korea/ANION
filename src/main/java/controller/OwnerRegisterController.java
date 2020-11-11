/*
========================================================================
파    일    명 : OwnerRegisterController.java
========================================================================
작    성    자 : 임원석, 정세진
작    성    일 : 2020.11.09
작  성  내  용 : 
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
	public String ownerRegister(@Valid OwnerRegisterRequest ownerRegisterRequest, Errors errors, Model model) {
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

}
