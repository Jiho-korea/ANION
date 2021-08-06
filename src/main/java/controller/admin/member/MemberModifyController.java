/*
========================================================================
파    일    명 : MemberModifyController.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.08.02
작  성  내  용 : 멤버 수정 Controller
========================================================================
*/
package controller.admin.member;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.admin.member.MemberSelectService;
import petProject.service.admin.member.MemberUpdateService;
import petProject.service.member.ChangePasswordService;
import petProject.service.member.ChangeProfileService;
import petProject.exception.MailException;
import petProject.exception.MemberDuplicateException;
import petProject.service.admin.member.MemberListService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Member;
import petProject.vo.dto.Memberlevel;
import petProject.vo.request.ChangeIdCommand;
import petProject.vo.request.ChangeNameCommand;
import petProject.vo.request.MemberProfileRequest;

@Controller
@RequestMapping("/admin/member/modify")
public class MemberModifyController {
	
	@Resource(name = "memberSelectService")
	MemberSelectService memberSelectService;
	
	@Resource(name = "changePasswordService")
	ChangePasswordService changePasswordService;

	@Resource(name = "memberUpdateService")
	MemberUpdateService memberUpdateService;
	
	@GetMapping(value= {"/{memberNumber}","/{member.memberNumber}"})
	public String memberModify(@PathVariable("memberNumber") int memberNumber, Model model) {
		try {
			Member member = memberSelectService.selectMemberByMemberNumber(memberNumber);
			model.addAttribute(member);
		} catch (Exception e) {
			e.printStackTrace();
			return "/home/main";
		}
		return "admin/member/memberModify";
	}
	
	@GetMapping("/updateName/{memberNumber}")
	public String updateName(@PathVariable("memberNumber") int memberNumber , Model model) {
		try {
			Member member = memberSelectService.selectMemberByMemberNumber(memberNumber);
			model.addAttribute(member);
			model.addAttribute("updateName", true);
		} catch (Exception e) {
			e.printStackTrace();
			return "/home/main";
		}
		return "admin/member/memberModify";
	}

	@PostMapping("/updateName")
	public String updateName(@Valid ChangeNameCommand changeNameCommand, Errors errors, HttpSession session,
			Model model) throws Exception {
		Member member = memberSelectService.selectMemberByMemberNumber(changeNameCommand.getMemberNumber());
		
		if (errors.hasErrors()) {
			model.addAttribute("updateName", true);
			model.addAttribute(member);
			return "admin/member/memberModify";
		}
		
		try {
			memberUpdateService.updateName(changeNameCommand);
			member.setMemberName(changeNameCommand.getMemberName());
			model.addAttribute(member);
			return "admin/member/memberModify";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(member);
			return "admin/member/memberModify";
		}
		
	}
		
} 

