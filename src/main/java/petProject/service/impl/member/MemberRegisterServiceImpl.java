/*
========================================================================
파    일    명 : MemberRegisterServiceImpl
========================================================================
작    성    자 : 임원석, 정세진, 송찬영
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 메소드 작성
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 추가
========================================================================
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.20
수  정  내  용 : insertMember부분에 암호화 코드 삽입, 이메일 인증 메서드 추가
========================================================================
수    정    자 : 강지호, 임원석
수    정    일 : 2020.11.24
수  정  내  용 : 트랜잭션 메소드 추가
========================================================================
*/

package petProject.service.impl.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeInsertException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberInsertException;
import petProject.service.email.MemberRegisterEmailService;
import petProject.service.email.EmailcodeDeleteService;
import petProject.service.member.LoginService;
import petProject.service.member.MemberRegisterService;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;
import petProject.vo.request.MemberRegisterRequest;

@Service("memberRegisterService")
@Transactional
public class MemberRegisterServiceImpl implements MemberRegisterService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private EmailcodeDAO emailcodeDAO;

	@Resource(name = "loginService")
	LoginService loginService;

	@Resource(name = "memberRegisterEmailService")
	MemberRegisterEmailService memberRegisterEmailService;

	@Resource(name = "emailcodeDeleteService")
	EmailcodeDeleteService emailcodeDeleteService;

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

	@Transactional
	public int updateAuthStatus(Emailcode emailcode) throws Exception {
		int cnt = memberDAO.updateAuthStatus(emailcode.getMemberId());
		if (cnt == 0) {
			throw new MemberAuthUpdateException("auth update failed");
		}
		emailcodeDeleteService.deleteEmailcode(emailcode);
		return cnt;
	}

	@Override
	public Emailcode insertCode(String memberId) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);

		Emailcode emailcode = new Emailcode();
		emailcode.setMemberId(member.getMemberId());
		emailcode.setEmailCode(Emailcode.random());

		int cnt = emailcodeDAO.insertEmailcode(emailcode);
		if (cnt == 0) {
			throw new EmailcodeInsertException("error");
		}
		return emailcode;
	}
	
	@Override
	@Transactional
	public void memberRegister(MemberRegisterRequest memberRegisterRequest, HttpServletRequest request, boolean isHtml)
			throws Exception {
		loginService.selectById(memberRegisterRequest.getMemberId());
		this.insertMember(memberRegisterRequest);
		Emailcode emailcode = this.insertCode(memberRegisterRequest.getMemberId());

		Member member = memberDAO.selectMemberById(memberRegisterRequest.getMemberId());
		memberRegisterEmailService.createMemberRegisterEmail(emailcode, member, request, isHtml);
	}

}
