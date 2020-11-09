/*
========================================================================
파    일    명 : OwnerRegisterController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : jsp 파일 매핑시켜주는 클래스
========================================================================
=============================== 함  수  설  명  ===============================

========================================================================
*/
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.service.PetRegisterService;
import petProject.vo.Pet;

@Controller
public class OwnerRegisterController {
	PetRegisterService petRegisterService;

	public void setPetRegisterService(PetRegisterService petRegisterService) {
		this.petRegisterService = petRegisterService;
	}

	@RequestMapping("/register/step1")
	public String registerStep1() {
		return "register/registerStep1";
	}

	@GetMapping("/register/step2")
	public String registerStep2Get() {
		return "redirect:/register/step1";
	}

	@GetMapping("/register/step3")
	public String registerStep3Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step2")
	public String registerStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Pet pet) {
		if (!agree) {
			return "register/registerStep1";
		}

		return "register/registerStep2";
	}

	@PostMapping("/register/step3")
	public String registerStep3(Pet pet) {
		try {
			// petRegisterService.regist(pet);
			return "register/registerStep3";
		} catch (Exception ex) {
			return "register/registerStep2";
		}
	}

}
