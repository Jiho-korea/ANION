/*
========================================================================
파    일    명 : EmailValidController.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 이메일 인증 컨트롤러
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.01.30
수  정  내  용 : 이메일 변경 인증 메서드 추가
========================================================================
*/
package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import petProject.dao.MemberDAO;
import petProject.exception.MemberAuthUpdateException;
import petProject.service.ChangeProfileService;
import petProject.service.MemberRegisterService;
import petProject.vo.ChangeIdCommand;
import petProject.vo.Member;

@Controller
public class EmailValidController {

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;

	@Resource(name = "changeProfileService")
	ChangeProfileService changeProfileService;
	
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(value = "/valid", method = RequestMethod.GET)
	public String validemail(@RequestParam(value = "memberId", required = true) String memberId, Model model) {

		// DB에 authStatus 업데이트
		try {
			memberRegisterService.updateAuthStatus(memberId);
			
			model.addAttribute("register", true);
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "register/valid";
	}

	@RequestMapping(value = "/updateId", method = RequestMethod.GET)
	public String updateEmail(ChangeIdCommand changeIdCommand, Model model, HttpSession session) {
		Member member = memberDAO.selectByMemberNumber(changeIdCommand.getMemberNumber());
			
		// DB에 authStatus 업데이트
		try {
			memberRegisterService.updateAuthStatus(member.getMemberId());
			changeProfileService.updateId(changeIdCommand);
			
			model.addAttribute("update", true);
		} catch (MemberAuthUpdateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.invalidate();
		
		return "register/valid";
	}
}
