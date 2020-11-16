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
import petProject.exception.MemberNotFoundException;
import petProject.service.LoginService;
import petProject.vo.LoginRequest;
import petProject.vo.Member;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member selectByIdPassword(LoginRequest loginRequest) throws Exception {
		Member member = memberDAO.selectByIdPassword(loginRequest);
		if (member == null) {
			throw new MemberNotFoundException("not found");
		}
		// TODO Auto-generated method stub
		return member;
	}
}
