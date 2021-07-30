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
package controller.member;

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
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.MemberAuthStatusException;
import petProject.exception.MemberNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.email.EmailValidService;
import petProject.service.member.LoginService;
import petProject.service.member.MemberRegisterService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Emailcode;
import petProject.vo.request.LoginRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource(name = "loginService")
	LoginService loginService;

	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;

	public LoginController() {
		super();
	}

	@GetMapping
	public String loginForm(@ModelAttribute("loginRequest") LoginRequest loginRequest,
			@RequestParam(value = "memberId", required = false) String memberId,
			@RequestParam(value = "emailcode", required = false) String emailcode,
			@CookieValue(value = "memory", required = false) Cookie cookie, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		if (emailcode != null && memberId != null) {
			try {
				Emailcode data = new Emailcode();
				data.setMemberId(memberId);
				data.setEmailCode(emailcode);

				emailValidService.valid(data);

				session.invalidate();
				ScriptWriter.write("인증이 완료되었습니다!", "login", request, response);
				return null;
			} catch (MemberNotFoundException e) {
				e.printStackTrace();
				ScriptWriter.write("잘못된 접근입니다", "home", request, response);
				return null;
			} catch (MemberAuthStatusException e) {
				e.printStackTrace();
				ScriptWriter.write("회원인증을 완료한 사용자입니다", "home", request, response);
				return null;
			} catch (EmailcodeNotMatchException e) {
				e.printStackTrace();
				ScriptWriter.write("만료된 링크입니다", "home", request, response);
				return null;
			} catch (NullPointerException e) {
				e.printStackTrace();
				ScriptWriter.write("로그인이 필요합니다", "home", request, response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return "login/loginFormPage";
			}
		} else if ((emailcode != null && memberId == null) || (emailcode == null && memberId != null)) {
			ScriptWriter.write("잘못된 접근입니다", "home", request, response);
			return null;
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
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
			HttpServletResponse response, HttpServletRequest request,
			@CookieValue(value = "popup01", required = false) Cookie cookie_popup01) {

		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}
		try {
			AuthInfo authInfo = loginService.selectMemberById(loginRequest.getMemberId(),
					loginRequest.getMemberPassword());

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
		} catch (Exception e) {
			e.printStackTrace();
			return "login/loginFormPage";
		}
	}

}
