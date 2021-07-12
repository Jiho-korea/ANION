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

import petProject.exception.MailException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.ScriptWriter;
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

		return "member/profile/memberProfile";
	}

	@PostMapping("/updateId")
	public String updateId(@Valid ChangeIdCommand changeIdCommand, Errors errors, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			model.addAttribute("updateId", true);

			return "member/profile/memberProfile";
		}
		try {
			changeProfileService.changeId(changeIdCommand, authInfo, request);

			authInfo.getMemberauth().setMemberAuthStatus(2); // what is this?

			session.setAttribute("tempAuth", true); // what is this?
			// model.addAttribute("update", true); // what is this?

			Cookie cookie_success_update_member_id = new Cookie("successUpdateMemberId", changeIdCommand.getMemberId());
			cookie_success_update_member_id.setPath("/");
			cookie_success_update_member_id.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_update_member_id);

			return "redirect:/email/sent";

		} catch (MemberDuplicateException e) {
			e.printStackTrace();
			model.addAttribute("updateId", true);
			errors.rejectValue("memberId", "duplicate.memberId");
			return "member/profile/memberProfile";
		} catch (MailException e) {
			e.printStackTrace();
			model.addAttribute("updateId", true);
			errors.rejectValue("memberId", "emailerror");
			return "member/profile/memberProfile";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("updateId", true);
			return "member/profile/memberProfile";
		}
	}

	@GetMapping("/updateName")
	public String updateName(ChangeNameCommand changeNameCommand, Model model) {
		model.addAttribute("updateName", true);

		return "member/profile/memberProfile";
	}

	@PostMapping("/updateName")
	public String updateName(@Valid ChangeNameCommand changeNameCommand, Errors errors, HttpSession session,
			Model model) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			model.addAttribute("updateName", true);

			return "member/profile/memberProfile";
		}

		try {
			changeProfileService.updateName(changeNameCommand, authInfo);

			return "member/profile/memberProfile";
		} catch (Exception e) {
			e.printStackTrace();
			return "member/profile/memberProfile";
		}

	}

	// 비밀번호 변경 버튼 클릭시
	@GetMapping("/updatePassword")
	public String check(ChangePasswordCommand changePasswordCommand) {
		return "member/profile/changePasswordForm";
	}

	@GetMapping("/passwordChange")
	public String passwordChange(
			@CookieValue(value = "successPasswordChange", required = false) Cookie cookie_success_password_change,
			Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		if (cookie_success_password_change == null) {
			ScriptWriter.write("잘못된 접근입니다.", "profile", request, response);
			return null;
		}

		Cookie cookie_delete_success_password_change = new Cookie("successPasswordChange",
				cookie_success_password_change.getValue());
		cookie_delete_success_password_change.setPath("/");
		cookie_delete_success_password_change.setMaxAge(0);
		response.addCookie(cookie_delete_success_password_change);

		session.invalidate();
		return "member/profile/changePasswordSuccess";
	}

	// 비밀번호 변경 완료시
	@PostMapping("/passwordChange")
	public String form(@Valid ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session,
			HttpServletResponse response) throws Exception {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (errors.hasErrors()) {
			return "member/profile/changePasswordForm";
		}

		try {
			if (changePasswordCommand.getCurrentPassword().equals(changePasswordCommand.getNewPassword())) {
				errors.reject("password.equal");
				return "member/profile/changePasswordForm";
			} else if (!changePasswordCommand.getNewPassword().equals(changePasswordCommand.getCheckNewPassword())) {
				errors.reject("checkNewPassword.notMatch");
				return "member/profile/changePasswordForm";
			}
			changePasswordService.changePassword(authInfo.getMemberId(), changePasswordCommand.getCurrentPassword(),
					changePasswordCommand.getNewPassword());

			Cookie cookie_success_password_change = new Cookie("successPasswordChange", null);
			cookie_success_password_change.setPath("/");
			cookie_success_password_change.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_password_change);
			return "redirect:/edit/passwordChange";
		} catch (MemberNotFoundException e) {
			errors.rejectValue("currentPassword", "password.notMatch");
			return "member/profile/changePasswordForm";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "password.notMatch");
			return "member/profile/changePasswordForm";
		}
	}

}