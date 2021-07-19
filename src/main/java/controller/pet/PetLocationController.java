package controller.pet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping(value = { "/{petRegistrationNumber}", "/{petRegistrationNumber}/{address}" })
	public String petLocationPopup(@PathVariable Integer petRegistrationNumber,
			@PathVariable(name = "address", required = false) String address, Model model) {
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);

		if (address != null) {
			model.addAttribute("address", address);
		}
		return "popup/petLocation/petLocationPopup";
	}

	@PostMapping("/register")
	public String petLocationRegister(@RequestParam Integer petRegistrationNumber, @RequestParam String address)
			throws Exception {
		try {
			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			
			pet.setPetAddress(address);
			petInfoUpdateService.updateLocation(pet);
		} catch (Exception e) {

		}

		return "popup/petLocation/petLocationPopup";
	}
}
