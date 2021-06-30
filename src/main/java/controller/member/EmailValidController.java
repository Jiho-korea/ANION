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
*/
package controller.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
import petProject.service.member.EmailValidService;
import petProject.service.member.EmailcodeDeleteService;
import petProject.vo.dto.Emailcode;

@Controller
@RequestMapping("/email")
public class EmailValidController {

	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	@Resource(name = "emailcodeDeleteService")
	EmailcodeDeleteService emailcodeDeleteService;

	@GetMapping("/valid")
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
				model.addAttribute("memberId", result);

				return "member/email/emailAuthenticationSuccess";
			}
			// 회원 가입시 result = null
			emailcodeDeleteService.deleteEmailcode(emailcode);
			model.addAttribute("memberId", emailcode.getMemberId());
			session.removeAttribute("tempAuth");
			return "member/email/emailAuthenticationSuccess";
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
