/*
========================================================================
파    일    명 : ProfileEditController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.15
작  성  내  용 : 회원정보 수정을 누르면 동작하는 컨트롤러
========================================================================
*/
package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.ChangeProfileService;
import petProject.service.ChangePasswordService;
import petProject.service.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.ChangeNameCommand;
import petProject.vo.ChangePasswordCommand;
import petProject.vo.Member;

@Controller
@RequestMapping("/edit")
public class ProfileEditController {

	@Resource(name = "loginService")
	LoginService loginService;

	@Resource(name = "changePasswordService")
	ChangePasswordService changePasswordService;

	@Resource(name = "changeProfileService")
	ChangeProfileService changeProfileService;

	@GetMapping("/updateId")
	public String updateId(ChangeIdCommand changeIdCommand, Model model) {
		model.addAttribute("updateId", true);

		return "info/profile";
	}

	@PostMapping("/updateId")
	public String updateId(@Valid ChangeIdCommand changeIdCommand, Errors errors, HttpSession session, HttpServletRequest request,
			Model model) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			model.addAttribute("updateId", true);

			return "info/profile";
		}
		try {
			changeProfileService.changeId(changeIdCommand, authInfo, request);
			
			model.addAttribute("update", true);
			return "register/signupSucess";
		} catch (Exception e) {
			e.printStackTrace();
			return "info/profile";
		}
	}

	@GetMapping("/updateName")
	public String updateName(ChangeNameCommand changeNameCommand, Model model) {
		model.addAttribute("updateName", true);

		return "info/profile";
	}

	@PostMapping("/updateName")
	public String updateName(@Valid ChangeNameCommand changeNameCommand, Errors errors, HttpSession session, Model model) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		if (errors.hasErrors()) {
			model.addAttribute("updateName", true);

			return "info/profile";
		}
		
		try {
			changeProfileService.updateName(changeNameCommand, authInfo);
			
			return "info/profile";
		} catch (Exception e) {
			e.printStackTrace();
			return "info/profile";
		}

	}

	// 회원정보 수정 버튼 클릭시
	@GetMapping
	public String check(Member member) {
		return "edit/passwordConfirm";
	}

	// 비밀번호 검증 버튼 클릭시
	@PostMapping
	public String form(Member member, ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
			throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		try {
			loginService.selectMemberById(authInfo.getMemberId(), member.getMemberPassword());

			return "edit/changePasswordForm";
		} catch (MemberNotFoundException e) {
			errors.rejectValue("memberPassword", "password.notMatch");

			return "edit/passwordConfirm";
		}
	}

	@PostMapping("/passwordChange")
	public String submitPassword(@Valid ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
			throws Exception {
		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		try {
			if (changePasswordCommand.getNewPassword() != "") {

				changePasswordService.changePassword(authInfo.getMemberId(), changePasswordCommand.getCurrentPassword(),
						changePasswordCommand.getNewPassword());

				return "edit/changePassword";
			}
			errors.rejectValue("newPassword", "password.null");

			return "edit/changePasswordForm";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "password.notMatch");

			return "edit/changePasswordForm";
		}
	}

}