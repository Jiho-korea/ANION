/*
========================================================================
파    일    명 : MemberFindController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : 비밀번호 찾기 컨트롤러
========================================================================
*/
package controller.member;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberNotFoundException;
import petProject.exception.MemberPasswordUpdateException;
import petProject.service.ScriptWriter;
import petProject.service.member.ChangePasswordService;
import petProject.service.member.MemberFindService;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;
import petProject.vo.request.MemberProfileRequest;

@Controller
@RequestMapping("/member/find")
public class MemberFindController {

	@Resource(name = "memberFindService")
	MemberFindService memberFindService;

	@Resource(name = "changePasswordService")
	ChangePasswordService changePasswordService;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;
	
	@GetMapping("/passwordForm")
	public String findPasswordForm(MemberProfileRequest memberProfileRequest) {
		return "member/find/passwordForm";
	}

	@GetMapping("/password")
	public String findPassword(
			@CookieValue(value = "successFindPassword", required = false) Cookie cookie_success_find_password,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (cookie_success_find_password == null) {
			ScriptWriter.write(messageSourceAccessor.getMessage("error"), "login", request, response);
			return null;
		}

		Cookie cookie_delete_success_find_password = new Cookie("successFindPassword",
				cookie_success_find_password.getValue());
		cookie_delete_success_find_password.setPath("/");
		cookie_delete_success_find_password.setMaxAge(0);
		response.addCookie(cookie_delete_success_find_password);

		model.addAttribute("memberId", cookie_success_find_password.getValue());
		return "member/find/sendTempPasswordSuccess";
	}

	@PostMapping("/password")
	public String findPassword(@Valid MemberProfileRequest memberProfileRequest, Errors error, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String tempPassword = Emailcode.random();
		if (error.hasErrors()) {
			return "member/find/passwordForm";
		}

		try {
			Member result = memberFindService.selectProfileById(memberProfileRequest.getMemberId());

			changePasswordService.updateTempPassword(result, tempPassword, request, true);

			Cookie cookie_success_find_password = new Cookie("successFindPassword", result.getMemberId());
			cookie_success_find_password.setPath("/");
			cookie_success_find_password.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_find_password);

			return "redirect:/member/find/password";
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("memberId.check"), "member/find/passwordForm", request, response);
			return null;
		} catch (MemberPasswordUpdateException e) {
			e.printStackTrace();
			ScriptWriter.write(messageSourceAccessor.getMessage("password.temp.fail"), "member/find/passwordForm", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "member/find/passwordForm";
		}
	}
}