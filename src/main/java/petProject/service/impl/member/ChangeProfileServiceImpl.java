/*
========================================================================
파    일    명 : ChangeProfileServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : Profile의 정보를 변경하는 service
========================================================================
*/

package petProject.service.impl.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeInsertException;
import petProject.exception.MailException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNameUpdateException;
import petProject.service.admin.member.MemberSelectService;
import petProject.service.email.ChangeProfileEmailService;
import petProject.service.member.ChangeProfileService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;
import petProject.vo.request.ChangeIdCommand;
import petProject.vo.request.ChangeNameCommand;

@Service("changeProfileService")
public class ChangeProfileServiceImpl implements ChangeProfileService {

	@Autowired
	private MemberDAO memberDAO;

	@Resource(name = "memberSelectService")
	MemberSelectService memberSelectService;

	@Autowired
	private EmailcodeDAO emailcodeDAO;

	@Resource(name = "changeProfileEmailService")
	ChangeProfileEmailService changeProfileEmailService;

	@Override
	public void selectById(String memberId) throws Exception {
		int member_cnt = memberDAO.selectByIdFromMember(memberId);
		int emailcode_cnt = memberDAO.selectByIdFromEmailcode(memberId);

		if (member_cnt != 0 || emailcode_cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
	}

	@Transactional
	public void updateName(ChangeNameCommand changeNameCommand, AuthInfo authInfo) throws Exception {
		Member member = memberSelectService.selectMemberByMemberNumber(changeNameCommand.getMemberNumber());

		member.setMemberName(changeNameCommand.getMemberName());
		authInfo.setMemberName(changeNameCommand.getMemberName());

		int cnt = memberDAO.updateName(member);
		if (cnt == 0) {
			throw new MemberNameUpdateException("name update error");
		}
	}

	@Transactional
	public Emailcode updateEmailcode(String memberId, ChangeIdCommand changeIdCommand) throws Exception {
		Emailcode emailcode = new Emailcode();

		emailcode.setMemberId(memberId);
		emailcode.setEmailCode(Emailcode.random());
		emailcode.setNewMemberId(changeIdCommand.getMemberId());

		int cnt = emailcodeDAO.updateEmailcode(emailcode);
		if (cnt == 0) {
			throw new EmailcodeInsertException("emailcode error");
		}

		return emailcode;
	}

	@Transactional
	public void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request)
			throws MailException, Exception {
		Member member = memberSelectService.selectMemberByMemberNumber(changeIdCommand.getMemberNumber());

		this.selectById(changeIdCommand.getMemberId());
		Emailcode emailcode = this.updateEmailcode(authInfo.getMemberId(), changeIdCommand);

		int cnt = emailcodeDAO.requestEmailUpdate(authInfo.getMemberId());
		if (cnt == 0) {
			throw new MemberAuthUpdateException("change auth error");
		}

		changeProfileEmailService.createChangeProfileEmail(changeIdCommand.getMemberId(), member.getMemberName(),
				request, true, emailcode.getEmailCode());
	}

}
