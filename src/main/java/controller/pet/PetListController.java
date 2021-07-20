/*
========================================================================
파    일    명 : PetListController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 반려견 목록 Controller
========================================================================
=============================== 함  수  설  명  ===============================
listPet : 세션에 저장되어있는 회원의 펫 목록 출력하는 함수
========================================================================
*/
package controller.pet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.pet.PetListService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Pet;

@Controller
@RequestMapping("/pet")
public class PetListController {

	private static final Logger logger = LoggerFactory.getLogger(PetListController.class);

	@Resource(name = "petListService")
	PetListService petListService;

	@GetMapping("/list")
	public String listPet(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		try {
			Cookie petLocation = new Cookie("petLocation", "true");
			petLocation.setPath(request.getContextPath() + "/pet/location");
			petLocation.setMaxAge(60 * 60 * 24 * 1);
			response.addCookie(petLocation);

			List<Pet> petList = petListService.selectPetList(authInfo.getMemberNumber());
			model.addAttribute("petList", petList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pet/list/petList";
	}

}
