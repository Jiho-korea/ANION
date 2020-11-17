/*
========================================================================
파    일    명 : LoginServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : MemberDAO의 selectByIdPassword메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberAuthStatusException;
import petProject.exception.MemberNotFoundException;
import petProject.service.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.Member;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public AuthInfo selectMemberById(String memberId, String memberPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("not found");
		}
		if (!member.matchPassword(memberPassword)) {
			throw new MemberNotFoundException("not found");
		}

		if (member.getMemberAuthStatus() != 0) {
			throw new MemberAuthStatusException("not valid");
		}
		
		return new AuthInfo(member.getMemberId(), member.getMemberName(), member.getMemberPhoneNumber(),
				member.getMemberRegisterDate(), member.getMemberLevel(), member.getMemberAuthStatus());
	}
}
