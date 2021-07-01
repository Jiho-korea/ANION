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
import petProject.service.ScriptWriter;
import petProject.service.member.MemberFindService;
import petProject.vo.dto.MemberIdProfile;
import petProject.vo.request.MemberFindIdRequest;

@Controller
@RequestMapping("/member/find")
public class MemberFindController {

	@Resource(name = "memberFindService")
	MemberFindService memberFindService;

	@GetMapping("/id")
	public String findIdForm(MemberFindIdRequest memberFindRequest) {
		return "member/find/idForm";
	}

	@PostMapping("/id")
	public String findId(@Valid MemberFindIdRequest memberFindRequest, Errors error, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (error.hasErrors()) {
			return "member/find/idForm";
		}
		try {
			MemberIdProfile memberIdProfile = memberFindService.findId(memberFindRequest);
			model.addAttribute("memberIdProfile", memberIdProfile);

			return "member/find/findIdSuccess";
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("이름 혹은 전화번호를 다시 확인해주세요", "member/find/id", request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			ScriptWriter.write("잘못된 접근입니다", "home", request, response);
			return null;
		}
	}

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
			String memberId = memberFindService.checkId(memberIdProfile.getMemberId());
			
			model.addAttribute("memberId", memberId);
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			ScriptWriter.write("이름 혹은 전화번호를 다시 확인해주세요", "member/find/passwordForm", request, response);
			return null;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "member/find/password";
	}
}
