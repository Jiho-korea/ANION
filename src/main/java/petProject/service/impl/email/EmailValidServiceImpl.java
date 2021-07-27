/*
========================================================================
파    일    명 : EmailValidServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : emailcode 확인기능 및 email 변경기능
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.03
수  정  내  용 : checkMemberAuthStatus 메소드 추가
========================================================================
*/
package petProject.service.impl.email;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthStatusException;
import petProject.exception.MemberIdUpdateException;
import petProject.exception.MemberNotFoundException;
import petProject.service.email.EmailValidService;
import petProject.service.member.MemberRegisterService;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;
import petProject.vo.dto.Memberauth;
import petProject.vo.request.ChangeIdCommand;

@Service("emailValidService")
@Transactional
public class EmailValidServiceImpl implements EmailValidService {

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;
	
	@Autowired
	private EmailcodeDAO emailcodeDAO;

	@Autowired
	private MemberDAO memberDAO;

	//DB의 authStatus를 통해 접근 불가 검증 메소드
	@Override
	public void checkMemberAuthStatus(Emailcode emailcode) throws Exception {
		Memberauth memberauth = memberDAO.checkMemberAuthStatus(emailcode);

		if (memberauth == null) {
			throw new MemberNotFoundException("memberId is not valid");
		}
		if (memberauth.getMemberAuthStatus() == 1) {
			throw new MemberAuthStatusException("authstatus is valid");
		}
	}
	
	// Emailcode의 필드(memberId, emailCode)를 사용하는 메소드
	@Override
	public Emailcode validCode(Emailcode emailcode) throws Exception {
		if (emailcode.getEmailCode().equals("")) {
			throw new EmailcodeNullException("emailcode is null");
		}

		// code를 통해서 관련행 추출
		Emailcode data = emailcodeDAO.selectEmailcode(emailcode);
		if (data != null) {
			memberRegisterService.updateAuthStatus(data.getMemberId());
		} else {
			throw new EmailcodeNotMatchException("emailcode not match");
		}
		return data;
	}

	// 회원수정시 id를 변경하는 메소드
	@Override
	public void updateEmail(Emailcode emailcode) throws Exception {
		Member member = memberDAO.selectMemberById(emailcode.getMemberId());

		ChangeIdCommand changeIdCommand = new ChangeIdCommand();

		changeIdCommand.setMemberId(emailcode.getNewMemberId());
		changeIdCommand.setMemberNumber(member.getMemberNumber());

		int cnt = memberDAO.updateId(changeIdCommand);
		if (cnt == 0) {
			throw new MemberIdUpdateException("new id is null");
		}
	}

	@Override
	public String valid(Emailcode emailcode) throws Exception {
		String result = null;
		Emailcode data = this.validCode(emailcode);

		if (data.getNewMemberId() != null) {
			this.updateEmail(data);
			result = data.getNewMemberId();
		}

		return result;
	}

}
