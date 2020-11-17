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
*/

package controller;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberInsertException;
import petProject.service.MemberRegisterService;
import petProject.vo.MemberRegisterRequest;
import petProject.service.MailSendService;

@Controller
@RequestMapping("/signup")
public class MemberRegisterController {
	
	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;
	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	public MemberRegisterController() {
		super();
	}

	@RequestMapping("/step1")
	public String signStep1(MemberRegisterRequest memberRegisterRequest) {
		return "register/signupForm";
	}

	@GetMapping("/step2")
	public String signupStep2Get() {
		return "redirect:/register/signupForm";
	}

	@PostMapping("/step2")
	public String signStep2(@Valid MemberRegisterRequest memberRegisterRequest, Errors errors, Model model, HttpServletRequest request) throws Exception {
		if (memberRegisterRequest.getMemberPhoneNumber().length() < 13
				&& !Pattern.matches("^[0-9]+$", memberRegisterRequest.getMemberPhoneNumber())) {
			errors.reject("no.number.check.memberRegisterRequest");
		}
		if (errors.hasErrors()) {
			return "register/signupForm";
		}

		try {
			memberRegisterService.selectById(memberRegisterRequest.getMemberId());
			
			memberRegisterService.insertMember(memberRegisterRequest);
			
			//이메일 발송
			mailSendService.sendAuthMail(memberRegisterRequest.getMemberId(), request);
			return "register/signupSucess";
		} catch (MemberInsertException e) {
			e.printStackTrace();
			errors.reject("failed.signup");
			return "register/signupForm";
		} catch (MemberDuplicateException e) {
			e.printStackTrace();
			errors.rejectValue("memberId", "duplicate.memberId");
			return "register/signupForm";
		} catch (Exception e) {
			e.printStackTrace();
			return "register/signupForm";
		}
		
	}

}
