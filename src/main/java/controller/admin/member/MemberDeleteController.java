/*
========================================================================
파    일    명 : MemberListContoller.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.07.30
작  성  내  용 : 멤버 삭제 Controller
========================================================================
*/
package controller.admin.member;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import petProject.service.admin.member.MemberDeleteService;
import petProject.service.admin.member.MemberListService;
import petProject.vo.dto.Member;

@Controller
@RequestMapping("/admin/member/delete")
public class MemberDeleteController {

	private static final Logger logger = LoggerFactory.getLogger(MemberDeleteController.class);

	@Resource(name = "memberDeleteService")
	MemberDeleteService memberDeleteSerivce;

	@GetMapping("/{memberNumber}")
	public String deleteMember(@PathVariable("memberNumber") int memberNumber) {
		try {
			memberDeleteSerivce.deleteMember(memberNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return "/home/main";
		}
		return "redirect:/admin/member/list";
	}

}
