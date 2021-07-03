/*
========================================================================
파    일    명 : NoseprintPetListController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.02
작  성  내  용 : 비문 등록 이벤트 반려견 목록 Controller
========================================================================
*/
package controller.event.noseprint;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import controller.pet.PetListController;
import petProject.service.pet.PetListService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/pet")
public class NoseprintPetListController {

	private static final Logger logger = LoggerFactory.getLogger(PetListController.class);

	@Resource(name = "petListService")
	PetListService petListService;

	@GetMapping("/list/event1")
	public String listPet(HttpSession session, Model model) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		try {
			List<Pet> noseprintPetList = petListService.selectNoseprintPetList(authInfo.getMemberNumber());
			model.addAttribute("petList", noseprintPetList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "event/noseprint/pet/list/petList";
	}

}
