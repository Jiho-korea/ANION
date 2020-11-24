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
	public String petInfo(@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
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

}
