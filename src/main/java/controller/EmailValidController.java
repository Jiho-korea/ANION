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
*/
package controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.EmailcodeDeleteException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberIdUpdateException;
import petProject.service.EmailValidService;
import petProject.vo.Emailcode;

@Controller
@RequestMapping("/email")
public class EmailValidController {

	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	@GetMapping("/valid")
	public String validForm(@Valid Emailcode emailcode, Errors errors) {

		return "register/valid";
	}

	@PostMapping("/valid")
	public String valid(@Valid Emailcode emailcode, Errors errors) throws Exception {
		try {
			int result = emailValidService.valid(emailcode);

			if (result == 1) {
				return "redirect:/logout";
			}
			return "redirect:/home";
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "notvalid");
			return "redirect:/email/valid";
		} catch (EmailcodeDeleteException e) {
			e.printStackTrace();
			errors.reject("memberId");
			return "redirect:/email/valid";
		} catch (MemberIdUpdateException e) {
			e.printStackTrace();
			errors.reject("newId");
			return "redirect:/email/valid";
		} catch (EmailcodeNullException e) {
			e.printStackTrace();
			return "redirect:/profile";
		}

	}
}
