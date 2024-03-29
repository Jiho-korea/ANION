/*
========================================================================
파    일    명 : LoginServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : MemberDAO의 selectByIdPassword메서드를 이용하는 서비스
========================================================================
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.20
수  정  내  용 : 이메일 암호화, 인증 익셉션 추가
========================================================================
*/
package petProject.service.impl.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNotFoundException;
import petProject.service.member.LoginService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Member;

@Service("loginService")
@Transactional(rollbackFor = SQLException.class)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public AuthInfo selectMemberById(String memberId, String memberPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if (member == null) {
			throw new MemberNotFoundException("not found");
		}
		// memberPassword : 사용자 입력값, member.getMemberPassword : 암호화된 값
		if (!passwordEncoder.matches(memberPassword, member.getMemberPassword())) {
			throw new MemberNotFoundException("not found");
		}
		return new AuthInfo(member.getMemberId(), member.getMemberNumber(), member.getMemberName(),
				member.getMemberPhoneNumber(), member.getMemberRegisterDate(), member.getMemberlevel(),
				member.getMemberauth());
	}

	@Override
	public void selectById(String memberId) throws Exception {
		int member_cnt = memberDAO.selectByIdFromMember(memberId);
		int emailcode_cnt = memberDAO.selectEmailcodeById(memberId);

		if (member_cnt != 0 || emailcode_cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
	}
}
