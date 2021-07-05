/*
========================================================================
파    일    명 : EmailValidController.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 이메일 인증 컨트롤러
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.01.30
수  정  내  용 : 이메일 변경 인증 메서드 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.03.23
수  정  내  용 : 에러처리 및 회원가입-이메일 변경할때 사용하는 세션이용
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.04.30
수  정  내  용 : Emailcode 테이블 데이터 삭제하는법 변경
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.05
수  정  내  용 : Double Submit 문제 해결
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
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.EmailcodeDeleteException;
import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthStatusException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberIdUpdateException;
import petProject.exception.MemberNotFoundException;
import petProject.service.ScriptWriter;
import petProject.service.email.EmailValidService;
import petProject.service.member.EmailcodeDeleteService;
import petProject.vo.dto.Emailcode;

@Controller
@RequestMapping("/email")
public class EmailValidController {

	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	@Resource(name = "emailcodeDeleteService")
	EmailcodeDeleteService emailcodeDeleteService;

	@GetMapping("/sent")
	public String emailSentSuccess(
			@CookieValue(value = "successMemberRegistration", required = false) Cookie cookie_success_member_registration,
			@CookieValue(value = "successUpdateMemberId", required = false) Cookie cookie_success_update_member_id,
			Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session)
			throws Exception {

		// 이메일 변경 과정(profile에서)을 안거치고 get방식으로 요청 한경우 (= 변경 확인 이메일 전송 완료 페이지에서 새로고침 한 경우)
		// 반려견 등록과정 step1을 안거치고 get방식으로 요청 한경우 (= 반려견 등록 완료 페이지에서 새로고침 한 경우)
		if (cookie_success_update_member_id == null && cookie_success_member_registration == null) {
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		}
		if (cookie_success_update_member_id != null) {
			Cookie cookie_delete_success_update_member_id = new Cookie("successUpdateMemberId",
					cookie_success_update_member_id.getValue());
			cookie_delete_success_update_member_id.setPath("/");
			cookie_delete_success_update_member_id.setMaxAge(0);
			response.addCookie(cookie_delete_success_update_member_id);
			model.addAttribute("memberId", cookie_success_update_member_id.getValue());
		} else if (cookie_success_member_registration != null) {
			Cookie cookie_delete_success_member_registration = new Cookie("successMemberRegistration",
					cookie_success_member_registration.getValue());
			cookie_delete_success_member_registration.setPath("/");
			cookie_delete_success_member_registration.setMaxAge(0);
			response.addCookie(cookie_delete_success_member_registration);
			model.addAttribute("memberId", cookie_success_member_registration.getValue());
		}

		return "member/email/emailSentSuccess";
	}

	@GetMapping("/validForm")
	public String validForm(@Valid Emailcode emailcode, Errors errors, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (errors.hasErrors()) {
			errors.reject("error");
		}
		try {
			emailValidService.checkMemberAuthStatus(emailcode);

			model.addAttribute("memberId", emailcode.getMemberId());
			return "member/email/emailAuthenticationForm";
		} catch (MemberNotFoundException e) {
			ScriptWriter.write("아이디를 다시 확인해주세요", "home", request, response);
			return null;
		} catch (MemberAuthStatusException e) {
			ScriptWriter.write("잘못된 접근입니다", "home", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다", "home", request, response);
			return null;
		}
	}

	@GetMapping("/valid")
	public String valid(@CookieValue(value = "successUpdateId", required = false) Cookie cookie_success_update_id,
			@CookieValue(value = "successValidMember", required = false) Cookie cookie_success_valid_member,
			Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		if (cookie_success_update_id == null && cookie_success_valid_member == null) {
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		}
		if (cookie_success_update_id != null) {
			Cookie cookie_delete_success_update_id = new Cookie("successUpdateId", cookie_success_update_id.getValue());
			cookie_delete_success_update_id.setPath("/");
			cookie_delete_success_update_id.setMaxAge(0);
			response.addCookie(cookie_delete_success_update_id);
			model.addAttribute("memberId", cookie_success_update_id.getValue());
		} else if (cookie_success_valid_member != null) {
			Cookie cookie_delete_success_valid_member = new Cookie("successValidMember",
					cookie_success_valid_member.getValue());
			cookie_delete_success_valid_member.setPath("/");
			cookie_delete_success_valid_member.setMaxAge(0);
			response.addCookie(cookie_delete_success_valid_member);
			model.addAttribute("memberId", cookie_success_valid_member.getValue());
		}

		return "member/email/emailAuthenticationSuccess";
	}

	@PostMapping("/valid")
	public String valid(@Valid Emailcode emailcode, Errors errors, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		if (errors.hasErrors()) {
			errors.reject("error");
			model.addAttribute("memberId", emailcode.getMemberId());
			return "member/email/emailAuthenticationForm";
		}

		try {
			String result = emailValidService.valid(emailcode);

			// 이메일 변경시 result != null
			if (result != null) {
				emailcodeDeleteService.deleteEmailcode(result);
				session.invalidate();

				Cookie cookie_success_update_id = new Cookie("successUpdateId", result);
				cookie_success_update_id.setPath("/");
				cookie_success_update_id.setMaxAge(60 * 60 * 24 * 1);

				response.addCookie(cookie_success_update_id);

				return "redirect:/email/valid";
			}
			// 회원 가입시 result = null
			emailcodeDeleteService.deleteEmailcode(emailcode);

			Cookie cookie_success_valid_member = new Cookie("successValidMember", emailcode.getMemberId());
			cookie_success_valid_member.setPath("/");
			cookie_success_valid_member.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_valid_member);

			return "redirect:/email/valid";
		} catch (EmailcodeNotMatchException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "notvalid");
			model.addAttribute("memberId", emailcode.getMemberId());
			return "member/email/emailAuthenticationForm";
		} catch (EmailcodeNullException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "NotNull");
			model.addAttribute("memberId", emailcode.getMemberId());
			return "member/email/emailAuthenticationForm";
		} catch (MemberIdUpdateException e) {
			e.printStackTrace();
			errors.reject("newId");
			model.addAttribute("memberId", emailcode.getMemberId());
			return "member/email/emailAuthenticationForm";
		} catch (EmailcodeDeleteException e) {
			e.printStackTrace();
			errors.reject("emailCode.deleteError");
			return "member/email/emailAuthenticationForm";
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
			errors.rejectValue("memberId", "memberId.edit");
			return "member/profile/memberProfile";
		} catch (NullPointerException e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다", "profile", request, response);
			return null;
		}

	}
}
