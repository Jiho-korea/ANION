/*
========================================================================
파    일    명 : PetLocationController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.20
작  성  내  용 : 사용자의 위치를 입력하는 팝업창
========================================================================
*/
package controller.pet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.PetInfoUpdateException;
import petProject.exception.PetNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.pet.PetInfoService;
import petProject.service.pet.PetInfoUpdateService;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/pet/location")
public class PetLocationController {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Resource(name = "petInfoUpdateService")
	PetInfoUpdateService petInfoUpdateService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@GetMapping(value = { "/{petRegistrationNumber}", "/{petRegistrationNumber}/{address}" })
	public String petLocationPopup(@PathVariable Integer petRegistrationNumber,
			@PathVariable(name = "address", required = false) String address,
			@RequestParam(name = "lat", required = false) String lat,
			@RequestParam(name = "lon", required = false) String lon, Model model) {

		model.addAttribute("petRegistrationNumber", petRegistrationNumber);

		if (address != null) {
			model.addAttribute("address", address);
		}
		if (lat != null & lon != null) {
			model.addAttribute("lat", lat);
			model.addAttribute("lon", lon);
		}

		return "popup/petLocation/petLocationPopup";
	}

	@PostMapping("/register")
	public String petLocationRegister(@RequestParam Integer petRegistrationNumber, @RequestParam String address,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Pet pet = petInfoService.selectPet(petRegistrationNumber);

			pet.setPetAddress(address);
			petInfoUpdateService.updateLocation(pet);
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "popup/petLocation/petLocationPopup", request, response);
			return null;
		} catch (PetInfoUpdateException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("bug"), "popup/petLocation/petLocationPopup", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "popup/petLocation/petLocationPopup", request, response);
			return null;
		}

		return "popup/petLocation/petLocationPopup";
	}
}
