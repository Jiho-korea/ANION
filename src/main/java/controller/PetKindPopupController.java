/*
========================================================================
파    일    명 : PetKindPopupController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.05
작  성  내  용 : petKind를 선택하는 Controller
========================================================================
*/
package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.dao.KindcodeDAO;
import petProject.service.KindcodeListService;
import petProject.vo.Kindcode;

@Controller
@RequestMapping("/popup")
public class PetKindPopupController {

	@Resource(name = "kindcodeListService")
	KindcodeListService kindcodeListService;
	
	@Autowired
	private KindcodeDAO kindcodeDAO;

	//대동견지도 클릭시 = "/petKind", 대동견지도에서 품종 클릭 후 = "/petKind/{petKindcode}"
	@GetMapping(value = {"/petKind/{petKindcode}", "/petKind"})
	public String popup2(Model model, @PathVariable(name = "petKindcode", required = false) String petKindcode)
			throws Exception {

		List<Kindcode> kindcodeList = kindcodeListService.selectKindcodeList();
		model.addAttribute("kindcodeList", kindcodeList);
		
		//redirect 됬을경우, 사용자가 클릭한 petKind가 콤보박스에 채워짐
		if(petKindcode != null) {
			Kindcode kindcode = kindcodeDAO.selectKindcode(petKindcode);
			model.addAttribute("kindcode", kindcode);
		}

		return "popup/petKind/petKindPopup";
	}

	//대동견지도에서 품종 클릭시 petKindcode를 넘겨주면서 redirect
	@GetMapping("/petKind/click/{petKindcode}")
	public String popup2_click(@PathVariable("petKindcode") String petKindcode) throws Exception {
		
		return "redirect:/popup/petKind/" + petKindcode;
	}
}
