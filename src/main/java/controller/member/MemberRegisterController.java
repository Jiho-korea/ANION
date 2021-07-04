/*
========================================================================
파    일    명 : MemberRegisterController.java
========================================================================
작    성    자 : 임원석, 정세진
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 컨트롤러 작성
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메서드 추가 
========================================================================
수    정    자 : 송찬영
수    정    일 : 2020.11.17
수  정  내  용 : 아이디 중복확인 로직 삭제(이메일 인증)
========================================================================
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.20
수  정  내  용 : 회원가입시 이메일 인증 링크 보내주는 메서드 추가
========================================================================
수    정    자 :강지호, 임원석
수    정    일 : 2020.11.24
수  정  내  용 : 트랜잭션 메소드 추가
========================================================================
수    정    자 :강지호
수    정    일 : 2021.06.24
수  정  내  용 : double submit 방지 기능 추가
========================================================================
*/
package controller.member;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MailException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberInsertException;
import petProject.service.ScriptWriter;
import petProject.service.member.MemberRegisterService;
import petProject.vo.AuthInfo;
import petProject.vo.request.MemberRegisterRequest;

@Controller
@PropertySource("classpath:/mail/config/mail.properties")
@RequestMapping("/signup")
public class MemberRegisterController {

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;

	public MemberRegisterController() {
		super();
	}

	@RequestMapping("/step1")
	public String signStep1(MemberRegisterRequest memberRegisterRequest, HttpServletResponse response,
			HttpServletRequest request, HttpSession session) throws Exception {

		if (session != null) {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
			// 로그인 한 상태에서 회원가입 페이지에는 못가도록 함
			if (authInfo != null) {
				ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
				return null;
			}
		}

		return "member/signup/signupForm";
	}

	@GetMapping("/step2")
	public String signupStep2(
			@CookieValue(value = "successMemberRegistration", required = false) Cookie cookie_success_member_registration,
			Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session)
			throws Exception {

		return "redirect:/signup/step1";
	}

	@PostMapping("/step2")
	public String signupStep2(@Valid MemberRegisterRequest memberRegisterRequest, Errors errors, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		/*
		 * if (memberRegisterRequest.getMemberPhoneNumber().length() < 13 &&
		 * !Pattern.matches("^[0-9]+$", memberRegisterRequest.getMemberPhoneNumber())) {
		 * errors.reject("no.number.check.memberRegisterRequest"); }
		 */
		if (!memberRegisterRequest.isPasswordEqualToCheckPassword()) {
			errors.rejectValue("checkPassword", "notmatch.password");
		}
		if (errors.hasErrors()) {
			return "member/signup/signupForm";
		}

		try {
			memberRegisterService.memberRegister(memberRegisterRequest, request, true);

			session.setAttribute("tempAuth", true);

			Cookie cookie_success_member_registration = new Cookie("successMemberRegistration",
					memberRegisterRequest.getMemberId());
			cookie_success_member_registration.setPath("/");
			cookie_success_member_registration.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_member_registration);
			return "redirect:/email/sent";
		} catch (MemberInsertException e) {
			e.printStackTrace();
			errors.reject("failed.signup");
			return "member/signup/signupForm";
		} catch (MemberDuplicateException e) {
			e.printStackTrace();
			errors.rejectValue("memberId", "duplicate.memberId");
			return "member/signup/signupForm";
		} catch (MailException e) {
			e.printStackTrace();
			errors.reject("failed.mail");
			return "member/signup/signupForm";
		} catch (Exception e) {
			e.printStackTrace();
			return "member/signup/signupForm";
		}

	}
}
