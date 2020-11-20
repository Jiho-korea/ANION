/*
========================================================================
파    일    명 : EmailValidController.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 이메일 인증 컨트롤러
========================================================================
*/
package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.exception.MemberAuthUpdateException;
import petProject.service.MemberRegisterService;
import petProject.vo.MemberRegisterRequest;

@Controller
public class EmailValidController {

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;

	@RequestMapping(value = "/valid", method = RequestMethod.GET)
	public String validemail(@RequestParam(value = "memberId", required = true) String memberId,
			@ModelAttribute("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest) {
		memberRegisterRequest.setMemberId(memberId);

		// DB에 authStatus 업데이트
		try {
			memberRegisterService.updateAuthStatus(memberId);
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "register/valid";
	}
}
