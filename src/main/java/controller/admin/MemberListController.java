/*
========================================================================
파    일    명 : MemberListContoller.java
========================================================================
작    성    자 : 강지호, 임원석
작    성    일 : 2020.xx.xx
작  성  내  용 : 멤버 리스트 Controller
========================================================================
=============================== 함  수  설  명  ===============================
listPet : 세션에 저장되어있는 회원의 펫 목록 출력하는 함수
========================================================================
*/
package controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petProject.service.admin.MemberListService;
import petProject.vo.Member;

@Controller
@RequestMapping("/admin/member")
public class MemberListController {

	private static final Logger logger = LoggerFactory.getLogger(MemberListController.class);

	@Resource(name = "memberListService")
	MemberListService memberListService;

	@GetMapping("/list")
	public String listPet(HttpSession session, Model model) {
		try {
			List<Member> memberList = memberListService.selectMemberList();
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			return "/home/main";
		}
		return "/admin/member/list";
	}

}
