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

import java.io.PrintWriter;

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
	public String validForm(@Valid Emailcode emailcode, Errors errors, Model model) {
		if (errors.hasErrors()) {
			errors.reject("error");
		}

		model.addAttribute("memberId", emailcode.getMemberId());
		return "register/valid";
	}

	@PostMapping("/valid")
	public String valid(@Valid Emailcode emailcode, Errors errors, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		if (errors.hasErrors()) {
			errors.reject("error");
			return "register/valid";
		}

		try {
			int result = emailValidService.valid(emailcode);

			// 이메일 변경시 result = 1
			if (result == 1) {
				session.invalidate();
				model.addAttribute("memberId", emailcode.getNewMemberId());
				return "home/validSuccess";
			}
			model.addAttribute("memberId", emailcode.getMemberId());
			session.removeAttribute("tempAuth");
			return "home/validSuccess";
		} catch (EmailcodeNotMatchException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "notvalid");
			return "register/valid";
		} catch (EmailcodeNullException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "NotNull");
			return "register/valid";
		} catch (MemberIdUpdateException e) {
			e.printStackTrace();
			errors.reject("newId");
			return "register/valid";
		} catch (EmailcodeDeleteException e) {
			e.printStackTrace();
			errors.reject("memberId");
			return "register/valid";
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
			errors.rejectValue("emailCode", "notvalid");
			return "register/valid";
		} catch (NullPointerException e) {
			e.printStackTrace();
			write("잘못된 접근입니다", request, response);
			return "info/profile";
		}

	}

	private void write(String message, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "');");
		out.println("location.href='" + request.getContextPath() + "/profile';");
		out.println("</script>");
		out.flush();
	}
}
