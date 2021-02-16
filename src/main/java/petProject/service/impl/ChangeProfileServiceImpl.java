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
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberDuplicateException;
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
	MailSendService mailSendService;

	private static Emailcode emailcode = new Emailcode();
	
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

		memberDAO.updateName(member);
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void updateEmailCode(String memberId, ChangeIdCommand changeIdCommand) throws Exception {
		emailcode.setMemberId(memberId);
		emailcode.setEmailCode(random());
		emailcode.setNewMemberId(changeIdCommand.getMemberId());
		
		memberDAO.updateEmailCode(emailcode);
	}

	@Transactional(rollbackFor = SQLException.class)
	public void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request) throws Exception {
		this.selectById(changeIdCommand.getMemberId());
		this.updateEmailCode(authInfo.getMemberId(), changeIdCommand);
		
		memberDAO.requestEmailUpdate(authInfo.getMemberId());
		Member member = memberDAO.selectByMemberNumber(changeIdCommand.getMemberNumber());
		
		mailSendService.sendMail(from_addr, from_name, changeIdCommand.getMemberId(), member, request, true, emailcode.getEmailCode());
	}

	@Transactional(rollbackFor = SQLException.class)
	public void updateId(ChangeIdCommand changeIdCommand) {
		memberDAO.updateId(changeIdCommand);
	}

	public static String random() {
		Random rand = new Random();
		String numStr = "";

		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));

			numStr += ran;
		}
		return numStr;
	}
}
