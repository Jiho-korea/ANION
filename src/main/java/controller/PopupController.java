/*
========================================================================
파    일    명 : PopupController.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.04.30
작  성  내  용 : 팝업 컨트롤러 생성
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.01
수  정  내  용 : 교육 대상자들을 위한 회원가입-반려견등록 연속 수행 로직 추가
========================================================================
*/
package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.KindcodeService;
import petProject.vo.Kindcode;

@Controller
@RequestMapping("/popup")
public class PopupController {

	@Resource(name = "kindcodeListService")
	KindcodeService kindcodeService;

	@GetMapping("/1")
	public String popup1(HttpServletRequest request) {
		return "popup/popup1";
	}

	// 교육 대상자 팝업의 처리 메소드
	@GetMapping("/1/click")
	public String popup1_click(HttpServletResponse response) throws Exception {
		Cookie cookie_popup01 = new Cookie("popup01", "true");
		cookie_popup01.setPath("/");
		cookie_popup01.setMaxAge(60 * 60 * 24 * 1);

		response.addCookie(cookie_popup01);

		return "redirect:/register/step1";
	}

	@GetMapping(value = {"/2/{petKindcode}", "/2"})
	public String popup2(Model model, @PathVariable(name = "petKindcode", required = false) String petKindcode)
			throws Exception {

		List<Kindcode> kindcodeList = kindcodeService.selectKindcodeList();
		model.addAttribute("kindcodeList", kindcodeList);
		
		if(petKindcode != null) {
			Kindcode kindcode = kindcodeService.selectKindcode(petKindcode);
			model.addAttribute("kindcode", kindcode);
		}

		return "popup/popup2";
	}

	@GetMapping("/2/click/{petKindcode}")
	public String popup2_click(@PathVariable("petKindcode") String petKindcode) throws Exception {
		
		return "redirect:/popup/2/" + petKindcode;
	}
}
