/*
========================================================================
파    일    명 : ChangeProfileServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : Profile의 정보를 변경하는 service
========================================================================
*/

package petProject.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeInsertException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberDuplicateException;
import petProject.exception.MemberNameUpdateException;
import petProject.service.ChangeProfileService;
import petProject.service.MailSendService;
import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.ChangeNameCommand;
import petProject.vo.Emailcode;
import petProject.vo.Member;

@Service("changeProfileService")
@Component
public class ChangeProfileServiceImpl implements ChangeProfileService {

	@Value("${mail.smtp.from_addr}")
	private String from_addr;
	@Value("${mail.smtp.from_name}")
	private String from_name;

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private EmailcodeDAO emailcodeDAO;

	@Autowired
	MailSendService mailSendService;
	
	@Override
	public int selectById(String memberId) throws Exception {
		int cnt = memberDAO.selectById(memberId);
		if (cnt != 0) {
			throw new MemberDuplicateException("duplicate memberId");
		}
		return cnt;
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void updateName(ChangeNameCommand changeNameCommand, AuthInfo authInfo) throws Exception {
		Member member = memberDAO.selectByMemberNumber(changeNameCommand.getMemberNumber());

		member.setMemberName(changeNameCommand.getMemberName());
		authInfo.setMemberName(changeNameCommand.getMemberName());

		int cnt = memberDAO.updateName(member);
		if(cnt == 0) {
			throw new MemberNameUpdateException("name update error");
		}
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public Emailcode updateEmailcode(String memberId, ChangeIdCommand changeIdCommand) throws Exception {
		Emailcode emailcode = new Emailcode();
		
		emailcode.setMemberId(memberId);
		emailcode.setEmailCode(emailcode.random());
		emailcode.setNewMemberId(changeIdCommand.getMemberId());
		
		int cnt = emailcodeDAO.updateEmailcode(emailcode);
		if(cnt == 0) {
			throw new EmailcodeInsertException("emailcode error");
		}
		
		return emailcode;
	}

	@Transactional(rollbackFor = SQLException.class)
	public void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request) throws Exception {
		Member member = memberDAO.selectByMemberNumber(changeIdCommand.getMemberNumber());
		this.selectById(changeIdCommand.getMemberId());
		Emailcode emailcode = this.updateEmailcode(authInfo.getMemberId(), changeIdCommand);
		
		int cnt = emailcodeDAO.requestEmailUpdate(authInfo.getMemberId());
		if(cnt == 0) {
			throw new MemberAuthUpdateException("change auth error");
		}
		
		mailSendService.sendMail(from_addr, from_name, changeIdCommand.getMemberId(), member, request, true, emailcode.getEmailCode());
	}

}
