/*
========================================================================
파    일    명 : LoginController.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 로그인 Controller 작성
========================================================================
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.17
수  정  내  용 : 이메일 검증 예외처리 추가
========================================================================
=============================== 함  수  설  명  ===============================
loginForm : 아이디 기억하기 구현하는 함수
login : 로그인 할 때 세션 생성후 로그인
========================================================================
*/
package controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberAuthStatusException;
import petProject.exception.MemberNotFoundException;
import petProject.service.EmailValidService;
import petProject.service.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.LoginRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource(name = "loginService")
	LoginService loginService;
	
	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	public LoginController() {
		super();
	}

	@GetMapping
	public String loginForm(@ModelAttribute("loginRequest") LoginRequest loginRequest,
			@CookieValue(value = "memory", required = false) Cookie cookie, HttpServletRequest request,
			HttpSession session) {
		
		if (cookie != null) {
			loginRequest.setMemberId(cookie.getValue());
			loginRequest.setMemory(true);
		}
		session.setAttribute("refererPage", request.getAttribute("refererPage"));
		// System.out.println("LoginController Get refererPage : " +
		// request.getAttribute("refererPage"));
		return "login/loginFormPage";
	}

	@PostMapping("/login")
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}

		try {
			AuthInfo authInfo = loginService.selectMemberById(loginRequest.getMemberId(),
					loginRequest.getMemberPassword());
			
			session.setAttribute("login", authInfo);
			session.setAttribute("memberId", loginRequest.getMemberId());

			Cookie memoryCookie = new Cookie("memory", loginRequest.getMemberId());
			memoryCookie.setPath("/");
			if (loginRequest.isMemory()) {
				memoryCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				memoryCookie.setMaxAge(0);
			}
			response.addCookie(memoryCookie);

			String refererPage = (String) session.getAttribute("refererPage");
			// System.out.println("LoginController Post refererPage : " + refererPage);
			if (refererPage == null) {
				return "redirect:/";
			} else {
				return "redirect:" + refererPage;
			}

			// return "redirect:/home";
		} catch (MemberNotFoundException e) {
			errors.reject("notfound");
			e.printStackTrace();
			return "login/loginFormPage";
		} catch (MemberAuthStatusException e) {
			errors.rejectValue("memberId" ,"notvalid");
			session.setAttribute("memberId", loginRequest.getMemberId());
			return "redirect:/email/valid";
		} catch (Exception e) {
			e.printStackTrace();
			return "login/loginFormPage";
		}
	}
	
}
