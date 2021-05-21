/*
========================================================================
파    일    명 : LogoutController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 로그아웃시 세션 제거
========================================================================
=============================== 함  수  설  명  ===============================
logout : session 제거
========================================================================
*/
package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.vo.request.LoginRequest;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(LoginRequest loginRequest, HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
