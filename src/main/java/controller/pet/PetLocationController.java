package controller.pet;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.dao.PetDAO;
import petProject.service.pet.PetInfoService;
import petProject.service.pet.PetInfoUpdateService;

@Controller
@RequestMapping("/pet")
public class PetLocationController {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Resource(name = "petInfoUpdateService")
	PetInfoUpdateService petInfoUpdateService;
	@Autowired
	PetDAO petDAO;

	@GetMapping(value = { "/location/{petRegistrationNumber}", "/location/{petRegistrationNumber}/{address}" })
	public String petLocationPopup(@PathVariable Integer petRegistrationNumber,
			@PathVariable(name = "address", required = false) String address, Model model) {
		model.addAttribute("petRegistrationNumber", petRegistrationNumber);
		if(address != null) {
			model.addAttribute("address", address);
		}
		return "popup/petLocation/petLocationPopup";
	}

}
