/*
========================================================================
파    일    명 : PetListAdminController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.30
작  성  내  용 : 관리자가 회원의 반려견 목록을 확인할 수 있도록 하는 Controller
========================================================================
*/
package controller.admin.pet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.pet.PetListService;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/admin/pet")
public class PetListAdminController {

	private static final Logger logger = LoggerFactory.getLogger(PetListAdminController.class);

	@Resource(name = "petListService")
	PetListService petListService;

	@GetMapping("/{memberNumber}")
	public String listPet(@PathVariable("memberNumber") int memberNumber, HttpSession session, Model model) {
		try {
			List<Pet> petList = petListService.selectPetList(memberNumber);
			model.addAttribute("petList", petList);
			model.addAttribute("admin", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pet/list/petList";
	}

}
