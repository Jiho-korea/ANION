/*
========================================================================
파    일    명 : ProfileEditController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.15
작  성  내  용 : 회원정보 수정을 누르면 동작하는 컨트롤러
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.01.30
수  정  내  용 : ID, NAME 변경 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.03.20
수  정  내  용 : 에러 처리 및 이메일 변경시 검증할 세션(tempAuth) 생성
========================================================================
*/
package controller.member;

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

import petProject.exception.MailException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.member.ChangePasswordService;
import petProject.service.member.ChangeProfileService;
import petProject.service.member.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.request.ChangeIdCommand;
import petProject.vo.request.ChangeNameCommand;
import petProject.vo.request.ChangePasswordCommand;

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
	public String updateId(@Valid ChangeIdCommand changeIdCommand, Errors errors, HttpSession session,
			HttpServletRequest request, Model model) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			model.addAttribute("updateId", true);

			return "info/profile";
		}
		try {
			changeProfileService.changeId(changeIdCommand, authInfo, request);

			authInfo.getMemberauth().setMemberAuthStatus(2);

			session.setAttribute("tempAuth", true);
			model.addAttribute("update", true);
			return "register/signupSucess";
		} catch (MemberDuplicateException e) {
			e.printStackTrace();
			model.addAttribute("updateId", true);
			errors.rejectValue("memberId", "duplicate.memberId");
			return "info/profile";
		} catch (MailException e) {
			e.printStackTrace();
			model.addAttribute("updateId", true);
			errors.rejectValue("memberId", "emailerror");
			return "info/profile";
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
	public String updateName(@Valid ChangeNameCommand changeNameCommand, Errors errors, HttpSession session,
			Model model) throws Exception {
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

	// 비밀번호 변경 버튼 클릭시
	@GetMapping
	public String check(ChangePasswordCommand changePasswordCommand) {
		return "edit/changePasswordForm";
	}

	// 비밀번호 변경 완료시
	@PostMapping("/passwordChange")
	public String form(@Valid ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session)
			throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}

		try {
			if (changePasswordCommand.getCurrentPassword().equals(changePasswordCommand.getNewPassword())) {
				errors.reject("password.equal");

				return "edit/changePasswordForm";
			} else if (!changePasswordCommand.getNewPassword().equals(changePasswordCommand.getCheckNewPassword())) {
				errors.reject("checkNewPassword.notMatch");

				return "edit/changePasswordForm";
			}

			changePasswordService.changePassword(authInfo.getMemberId(), changePasswordCommand.getCurrentPassword(),
					changePasswordCommand.getNewPassword());
			session.invalidate();
			return "edit/changePassword";
		} catch (MemberNotFoundException e) {
			errors.rejectValue("currentPassword", "password.notMatch");

			return "edit/changePasswordForm";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "password.notMatch");

			return "edit/changePasswordForm";
		}
	}

}