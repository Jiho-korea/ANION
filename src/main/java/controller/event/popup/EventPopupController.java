/*
========================================================================
파    일    명 : EventPopupController.java
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
package controller.event.popup;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popup")
public class EventPopupController {

	@GetMapping("/1")
	public String popup1(HttpServletRequest request) {
		return "popup/event/popup1";
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

}
