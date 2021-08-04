/*
========================================================================
파    일    명 : ChangePasswordServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : encode화 된 비밀번호를 매칭하여 변경
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.03
수  정  내  용 : 임시 비밀번호 변경 메서드 추가
========================================================================
*/
package petProject.service.impl.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.exception.MemberPasswordUpdateException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.email.MemberPasswordEmailSendService;
import petProject.service.member.ChangePasswordService;
import petProject.vo.dto.Member;

@Service("changePasswordService")
@Transactional(rollbackFor = SQLException.class)
public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	MemberPasswordEmailSendService memberPasswordEmailSendService;

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void changePassword(String memberId, String oldPassword, String newPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}

		if (!passwordEncoder.matches(oldPassword, member.getMemberPassword()))
			throw new WrongIdPasswordException("not Matching");

		member.setMemberPassword(passwordEncoder.encode(newPassword));
		int cnt = memberDAO.updatePassword(member);
		if (cnt == 0) {
			throw new MemberPasswordUpdateException("password update error");
		}
	}

	@Override
	public void updateTempPassword(Member member, String tempPassword, HttpServletRequest request, boolean isHtml)
			throws Exception {
		member.setMemberPassword(passwordEncoder.encode(tempPassword));
		
		int cnt = memberDAO.updatePassword(member);
		if (cnt == 0) {
			throw new MemberPasswordUpdateException("password update error");
		}
		memberPasswordEmailSendService.sendPassword(member, tempPassword, request, isHtml);
	}

}
