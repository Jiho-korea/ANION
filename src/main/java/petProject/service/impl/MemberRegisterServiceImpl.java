/*
========================================================================
파    일    명 : MemberRegisterServiceImpl
========================================================================
작    성    자 : 임원석, 정세진, 송찬영
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 메소드 작성
========================================================================
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 추가
========================================================================
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.20
수  정  내  용 : insertMember부분에 암호화 코드 삽입, 이메일 인증 메서드 추가
========================================================================
*/

package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petProject.dao.MemberDAO;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberInsertException;
import petProject.service.MemberRegisterService;
import petProject.vo.MemberRegisterRequest;

@Service("memberRegisterService")
@Transactional
public class MemberRegisterServiceImpl implements MemberRegisterService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public int insertMember(MemberRegisterRequest memberRegisterRequest) throws Exception {

		String enco = passwordEncoder.encode(memberRegisterRequest.getMemberPassword());
		memberRegisterRequest.setMemberPassword(enco);
		int cnt = memberDAO.insertMember(memberRegisterRequest);
		if (cnt == 0) {
			throw new MemberInsertException("Insert failed");
		}
		// TODO Auto-generated method stub
		return cnt;
	}

	public int selectById(String memberId) throws Exception {
		int cnt = memberDAO.selectById(memberId);
		if(cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
		return cnt;
	}

	@Override
	public int updateAuthStatus(String memberId) throws Exception {
		int cnt = memberDAO.updateAuthStatus(memberId);
		if(cnt == 0) {
			throw new MemberInsertException("Insert failed");
		}
		return cnt;
	}
}
