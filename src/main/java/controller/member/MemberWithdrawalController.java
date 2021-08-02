/*
========================================================================
파    일    명 : MemberWithdrawalController.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : 회원탈퇴 처리 컨트롤러
========================================================================
*/
package controller.member;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberWithdrawalException;
import petProject.service.ScriptWriter;
import petProject.service.member.MemberWithdrawalService;
import petProject.vo.AuthInfo;
import petProject.vo.request.MemberWithdrawalRequest;

@Controller
@RequestMapping("/memberWithdrawal")
public class MemberWithdrawalController {

	@Resource(name = "withdrawalService")
	MemberWithdrawalService memberWithdrawalService;

	@GetMapping
	public String withdrawalPage(MemberWithdrawalRequest memberWithdrawalRequest, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (authInfo.getMemberauth().getMemberAuthStatus() == 3) {
			return "member/memberWithdrawal/memberWithdrawalCancel";
		}
		return "member/memberWithdrawal/memberWithdrawalForm";
	}

	@GetMapping("/request")
	public String memberWithdrawalRequest(
			@CookieValue(value = "successMemberWithdrawalRequest", required = false) Cookie cookie_success_memberWithdrawal_request,
			HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		if (cookie_success_memberWithdrawal_request == null) {
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		}

		Cookie cookie_delete_success_memberWithdrawal_request = new Cookie("successMemberWithdrawalRequest",
				cookie_success_memberWithdrawal_request.getValue());
		cookie_delete_success_memberWithdrawal_request.setPath("/");
		cookie_delete_success_memberWithdrawal_request.setMaxAge(0);
		response.addCookie(cookie_delete_success_memberWithdrawal_request);

		session.invalidate();
		return "member/memberWithdrawal/memberWithdrawalSuccess";
	}

	// 탈퇴하는 이유 등록 & memberAuthStatus를 3으로 변경
	@PostMapping("/request")
	public String memberWithdrawalRequest(MemberWithdrawalRequest memberWithdrawalRequest, Errors errors, HttpServletResponse response,
			HttpSession session) {
		try {
			memberWithdrawalService.requestMemberWithdrawal(memberWithdrawalRequest);

			Cookie cookie_success_memberWithdrawal_request = new Cookie("successMemberWithdrawalRequest", null);
			cookie_success_memberWithdrawal_request.setPath("/");
			cookie_success_memberWithdrawal_request.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_memberWithdrawal_request);

			return "redirect:/memberWithdrawal/request";
		} catch (MemberWithdrawalException e) {
			e.printStackTrace();
			errors.rejectValue("comment", "error");
			return "redirect:/memberWithdrawal";
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
			errors.reject("memberId");
			return "redirect:/memberWithdrawal";
		}
	}

	@GetMapping("/cancel")
	public String cancelMemberWithdrawal(
			@CookieValue(value = "successMemberWithdrawalCancel", required = false) Cookie cookie_success_memberWithdrawal_cancel,
			HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		if (cookie_success_memberWithdrawal_cancel == null) {
			ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			return null;
		}

		Cookie cookie_delete_success_memberWithdrawal_cancel = new Cookie("successMemberWithdrawalCancel",
				cookie_success_memberWithdrawal_cancel.getValue());
		cookie_delete_success_memberWithdrawal_cancel.setPath("/");
		cookie_delete_success_memberWithdrawal_cancel.setMaxAge(0);
		response.addCookie(cookie_delete_success_memberWithdrawal_cancel);

		session.invalidate();
		ScriptWriter.write("회원탈퇴 취소 처리가 완료되었습니다!", "login", request, response);
		return null;
	}

	// withdrawal의 record 삭제 및 memberAuthStatus를 1로 변경
	@PostMapping("/cancel")
	public String cancelMemberWithdrawal(MemberWithdrawalRequest memberWithdrawalRequest, HttpServletResponse response,
			HttpSession session) {
		try {
			memberWithdrawalService.cancelMemberWithdrawal(memberWithdrawalRequest.getMemberNumber());

			Cookie cookie_success_memberWithdrawal_cancel = new Cookie("successMemberWithdrawalCancel", null);
			cookie_success_memberWithdrawal_cancel.setPath("/");
			cookie_success_memberWithdrawal_cancel.setMaxAge(60 * 60 * 24 * 1);

			response.addCookie(cookie_success_memberWithdrawal_cancel);

			return "redirect:/memberWithdrawal/cancel";
		} catch (MemberWithdrawalException e) {
			e.printStackTrace();
			return "redirect:/memberWithdrawal";
		}
	}
}
