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

import petProject.dao.MemberDAO;
import petProject.exception.MemberDuplicateException;
import petProject.service.ChangeProfileService;
import petProject.service.MailSendService;
import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.ChangeNameCommand;
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
	public void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request) throws Exception {
		this.selectById(changeIdCommand.getMemberId());
		
		memberDAO.requestEmailUpdate(authInfo.getMemberId());
		Member member = memberDAO.selectByMemberNumber(changeIdCommand.getMemberNumber());
		
		mailSendService.sendMail(from_addr, from_name, changeIdCommand.getMemberId(), member, request, true);
	}

	@Transactional(rollbackFor = SQLException.class)
	public void updateId(ChangeIdCommand changeIdCommand) {
		memberDAO.updateId(changeIdCommand);
	}

}
