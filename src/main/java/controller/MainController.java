/*
========================================================================
파    일    명 : MainController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 메인 페이지 Controller
========================================================================
=============================== 함  수  설  명  ===============================
listPet : 세션에 저장되어있는 회원의 펫 목록 출력하는 함수
========================================================================
*/
package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.PetListService;
import petProject.vo.AuthInfo;
import petProject.vo.Pet;

@Controller
@RequestMapping("/main")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Resource(name = "petNameListService")
	PetListService petListService;

	@GetMapping("/list")
	public String listPet(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		try {
			List<Pet> petList = petListService.selectPetList(authInfo.getMemberNumber());
			model.addAttribute("petList", petList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/main/list";
	}

}
