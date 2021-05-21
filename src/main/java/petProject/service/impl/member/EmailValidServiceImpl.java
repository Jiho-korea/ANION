/*
========================================================================
파    일    명 : EmailValidServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : emailcode 확인기능 및 email 변경기능
========================================================================
*/
package petProject.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberIdUpdateException;
import petProject.service.member.EmailValidService;
import petProject.vo.ChangeIdCommand;
import petProject.vo.Emailcode;
import petProject.vo.Member;

@Service("emailValidService")
@Transactional
public class EmailValidServiceImpl implements EmailValidService {

	@Autowired
	private EmailcodeDAO emailcodeDAO;

	@Autowired
	private MemberDAO memberDAO;

	// Emailcode의 필드(memberId, emailCode)를 사용하는 메소드
	@Override
	public Emailcode validCode(Emailcode emailcode) throws Exception {
		if (emailcode.getEmailCode().equals("")) {
			throw new EmailcodeNullException("emailcode is null");
		}

		// code를 통해서 관련행 추출
		Emailcode data = emailcodeDAO.selectEmailcode(emailcode);
		if (data != null) {
			int cnt = memberDAO.updateAuthStatus(data.getMemberId());
			if (cnt == 0) {
				throw new MemberAuthUpdateException("Auth Update Exception");
			}
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
