package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.ChangePasswordService;
import petProject.service.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.ChangePasswordCommand;
import petProject.vo.Member;

@Controller
@RequestMapping("/edit")
public class EditController {

	@Resource(name = "loginService")
	LoginService loginService;
	
	@Resource(name = "changePasswordService")
	ChangePasswordService changePasswordService;

	// 회원정보 수정 버튼 클릭시
	@GetMapping
	public String check(Member member) {
		return "edit/passwordConfirm";
	}

	// 비밀번호 확인 버튼 클릭시
	@PostMapping("/form")
	public String form(Member member, Errors errors, HttpSession session) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		try {
			loginService.selectMemberById(authInfo.getMemberId(), member.getMemberPassword());
			
			return "edit/changeForm";
		} catch (MemberNotFoundException e) {
			errors.rejectValue("memberPassword", "password.notMatch");

			return "edit/passwordConfirm";
		}
	}

	// 비밀번호 변경 폼
	@GetMapping("/passwordForm")
	public String passwordform(ChangePasswordCommand changePasswordCommand, HttpSession session) {
		return "edit/changePasswordForm";
	}
	

	@PostMapping("/changePassword")
	public String submitPassword(ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
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