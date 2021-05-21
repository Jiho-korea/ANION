/*
========================================================================
파    일    명 : PetInfoController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 컨트롤러
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.01.25
수  정  내  용 : 견명 변경 폼 이동 기능 구현
========================================================================
*/

package controller.pet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.PetInfoUpdateException;
import petProject.exception.PetNotFoundException;
import petProject.service.pet.PetInfoService;
import petProject.service.pet.PetInfoUpdateService;
import petProject.vo.Pet;
import petProject.vo.ScriptWriter;
import petProject.vo.petInfo.PetNameUpdateRequest;

@Controller
@RequestMapping("/info/pet")
public class PetInfoController {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Resource(name = "petInfoUpdateService")
	PetInfoUpdateService petInfoUpdateService;

	public PetInfoController() {
		super();
	}

	@GetMapping
	public String petInfo(@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);

			return "info/pet";
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "list/pet";
		}

	}

	@GetMapping("/updatePname")
	public String updatePnameGet(
			@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
			PetNameUpdateRequest petNameUpdateRequest, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {

			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);
			model.addAttribute("updatePname", true);

			return "info/pet";
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "info/pet";
		}

	}

	@PostMapping("/updatePname")
	public String updatePnamePost(@Valid PetNameUpdateRequest petNameUpdateRequest, Errors errors, Model model) {
		if (errors.hasErrors()) {

			try {
				Pet pet = petInfoService.selectPet(petNameUpdateRequest.getPetRegistrationNumber());
				model.addAttribute("pet", pet);
				model.addAttribute("updatePname", true);
				return "info/pet";
			} catch (PetNotFoundException e) {
				e.printStackTrace();
				return "list/pet";
			} catch (Exception e) {
				e.printStackTrace();
				return "list/pet";
			}

		}
		try {
			petInfoUpdateService.updatePetName(petNameUpdateRequest);
			return "redirect:/info/pet?" + "petRegistrationNumber=" + petNameUpdateRequest.getPetRegistrationNumber();
		} catch (PetInfoUpdateException e) {
			e.printStackTrace();
			return "info/pet";
		} catch (Exception e) {
			e.printStackTrace();
			return "info/pet";
		}

	}

}
