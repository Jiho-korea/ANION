/*
========================================================================
파    일    명 : ChangePasswordServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : encode화 된 비밀번호를 매칭하여 변경
========================================================================
*/

package petProject.service.impl.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.member.ChangePasswordService;
import petProject.vo.dto.Member;

@Service("changePasswordService")
@Component
public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private MemberDAO memberDAO;

	@Transactional(rollbackFor = SQLException.class)
	public void changePassword(String memberId, String oldPassword, String newPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}

		if (!passwordEncoder.matches(oldPassword, member.getMemberPassword()))
			throw new WrongIdPasswordException("not Matching");

		member.setMemberPassword(passwordEncoder.encode(newPassword));
		memberDAO.updatePassword(member);
	}

}
