package controller.pet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String petLocationRegister(@RequestParam Integer petRegistrationNumber, @RequestParam String address,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Pet pet = petInfoService.selectPet(petRegistrationNumber);

			pet.setPetAddress(address);
			petInfoUpdateService.updateLocation(pet);
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("등록 후 사용해주세요!", "popup/petLocation/petLocationPopup", request, response);
			return null;
		} catch (PetInfoUpdateException e) {
			e.printStackTrace();
			ScriptWriter.write("위치를 재 설정 해주세요!", "popup/petLocation/petLocationPopup", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다.", "popup/petLocation/petLocationPopup", request, response);
			return null;
		}

		return "popup/petLocation/petLocationPopup";
	}
}
