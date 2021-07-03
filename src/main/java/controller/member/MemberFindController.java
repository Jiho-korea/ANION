package controller.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.exception.MemberNotFoundException;
import petProject.exception.MemberPasswordUpdateException;
import petProject.service.ScriptWriter;
import petProject.service.member.ChangePasswordService;
import petProject.service.member.MemberFindService;
import petProject.service.email.MemberPasswordEmailSendService;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.MemberIdProfile;

@Controller
@RequestMapping("/member/find")
public class MemberFindController {

	@Resource(name = "memberFindService")
	MemberFindService memberFindService;

	@Resource(name = "changePasswordService")
	ChangePasswordService changePasswordService;

	@Resource(name = "memberPasswordEmailSendService")
	MemberPasswordEmailSendService memberPasswordEmailSendService;

	@GetMapping("/password")
	public String findPasswordForm(MemberIdProfile memberIdProfile) {
		return "member/find/passwordForm";
	}

	@PostMapping("/password")
	public String findPassword(@Valid MemberIdProfile memberIdProfile, Errors error, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (error.hasErrors()) {
			return "member/find/passwordForm";
		}

		try {
			String tempPassword = Emailcode.random();
			MemberIdProfile result = memberFindService.checkId(memberIdProfile.getMemberId());

			changePasswordService.updateTempPassword(memberIdProfile.getMemberId(), tempPassword);

			memberPasswordEmailSendService.sendPassword(result, tempPassword, request, true);

			model.addAttribute("memberId", result.getMemberId());
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("ID를 다시 확인해주세요", "member/find/passwordForm", request, response);
			return null;
		} catch (MemberPasswordUpdateException e) {
			e.printStackTrace();
			ScriptWriter.write("임시 비밀번호 발급에 실패했습니다. 다시 시도해주세요!", "member/find/passwordForm", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "member/find/passwordForm";
		}
		return "member/find/sendTempPasswordSuccess";
	}
}
