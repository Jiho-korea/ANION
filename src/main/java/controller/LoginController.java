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
수    정    자 : 송찬영
수    정    일 : 2021.03.20
수  정  내  용 : 인증되지 않은 사용자를 구분하기위해 임시 세션(tempAuth) 사용
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
import org.springframework.ui.Model;
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

		String memberId = (String) session.getAttribute("memberId");
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (memberId != null) {
			session.removeAttribute("memberId");
			if (authInfo != null) {
				session.removeAttribute("login");
			}
		}

		if (cookie != null) {
			loginRequest.setMemberId(cookie.getValue());
			loginRequest.setMemory(true);
		}
		session.setAttribute("refererPage", request.getAttribute("refererPage"));
		// System.out.println("LoginController Get refererPage : " +
		// request.getAttribute("refererPage"));
		return "login/loginFormPage";
	}

	@PostMapping()
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session, Model model,
			HttpServletResponse response, HttpServletRequest request,
			@CookieValue(value = "popup01", required = false) Cookie cookie_popup01) {
		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}

		try {
			AuthInfo authInfo = loginService.selectMemberById(loginRequest.getMemberId(),
					loginRequest.getMemberPassword());

			if (authInfo.getMemberauth().getMemberAuthStatus() == 2) {
				session.setAttribute("tempAuth", true);
			}

			session.setAttribute("login", authInfo);

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
				// 교육 이벤트 팝업의 등록하러가기 버튼을 누를 시 로그인 후 바로 반려견 등록 페이지로 이동 시킴
				if (cookie_popup01 != null) {
					return "redirect:/register/step1";
				}
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
			session.setAttribute("tempAuth", true);
			return "redirect:/email/valid?memberId=" + loginRequest.getMemberId();
		} catch (Exception e) {
			e.printStackTrace();
			return "login/loginFormPage";
		}
	}

}
