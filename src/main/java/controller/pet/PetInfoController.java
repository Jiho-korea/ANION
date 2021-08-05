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
수    정    자 : 송찬영
수    정    일 : 2021.05.23
수  정  내  용 : 반려견 삭제 기능 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.03
수  정  내  용 : 업로드 폴더의 사진 삭제기능 추가
========================================================================
*/
package controller.pet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.dao.ImageDAO;
import petProject.dao.PetDAO;
import petProject.exception.PetDeleteException;
import petProject.exception.PetInfoUpdateException;
import petProject.exception.PetNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.pet.PetDeleteService;
import petProject.service.pet.PetInfoService;
import petProject.service.pet.PetInfoUpdateService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Pet;
import petProject.vo.request.PetNameUpdateRequest;

@Controller
@RequestMapping("/info/pet")
public class PetInfoController {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Resource(name = "petInfoUpdateService")
	PetInfoUpdateService petInfoUpdateService;

	@Resource(name = "petDeleteService")
	PetDeleteService petDeleteService;

	@Autowired
	PetDAO petDAO;

	@Autowired
	ImageDAO imageDAO;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	public PetInfoController() {
		super();
	}

	@GetMapping
	public String petInfo(@RequestParam(value = "petRegistrationNumber", required = true) Integer petRegistrationNumber,
			HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		// 관리자 페이지에서 회원 반려견 삭제 불가
		if (petDAO.selectMemberNumber(petRegistrationNumber) == authInfo.getMemberNumber()) {
			model.addAttribute("delete", true);
		}

		try {

			Pet pet = petInfoService.selectPet(petRegistrationNumber);
			model.addAttribute("pet", pet);
			model.addAttribute("petRegistrationNumber", petRegistrationNumber);

			return "pet/info/petInfo";
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "home", request, response); // url로 아무 펫번호나 입력했을 때 여기서 걸림
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "pet/list/petList";
		}

	}

	// pet페이지에서 petRegistrationNumber받아서 삭제하는 메소드
	@PostMapping
	public String petDelete(@RequestParam(value = "petRegistrationNumber", required = true) int petRegistrationNumber,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			petDeleteService.deletePet(petRegistrationNumber, request);

			return "redirect:/pet/list";
		} catch (PetDeleteException e) { // DB에 없는 pet일경우 DeleteException발생
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("pet.list.check"), "pet/list", request, response);
			return null;
		} catch (Exception e) { // 예외발생시 다시 pet페이지로 이동
			e.printStackTrace();
			return "redirect:/info/pet?petRegistrationNumber=" + petRegistrationNumber;
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

			return "pet/info/petInfo";
		} catch (PetNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "home", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "pet/info/petInfo";
		}

	}

	@PostMapping("/updatePname")
	public String updatePnamePost(@Valid PetNameUpdateRequest petNameUpdateRequest, Errors errors, Model model) {
		if (errors.hasErrors()) {

			try {
				Pet pet = petInfoService.selectPet(petNameUpdateRequest.getPetRegistrationNumber());
				model.addAttribute("pet", pet);
				model.addAttribute("updatePname", true);
				return "pet/info/petInfo";
			} catch (PetNotFoundException e) {
				e.printStackTrace();
				return "pet/list/petList";
			} catch (Exception e) {
				e.printStackTrace();
				return "pet/list/petList";
			}

		}
		try {
			petInfoUpdateService.updatePetName(petNameUpdateRequest);
			return "redirect:/info/pet?" + "petRegistrationNumber=" + petNameUpdateRequest.getPetRegistrationNumber();
		} catch (PetInfoUpdateException e) {
			e.printStackTrace();
			return "pet/info/petInfo";
		} catch (Exception e) {
			e.printStackTrace();
			return "pet/info/petInfo";
		}

	}

}
