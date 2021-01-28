package petProject.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.service.ChangeProfileService;
import petProject.service.MailSendService;
import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.Member;

@Service("changeIdService")
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

	@Transactional(rollbackFor = SQLException.class)
	public void updateName(AuthInfo authInfo, String newName) throws Exception {
		Member member = memberDAO.selectMemberById(authInfo.getMemberId());

		member.setMemberName(newName);
		authInfo.setMemberName(newName);

		memberDAO.updateName(member);
	}

	@Transactional(rollbackFor = SQLException.class)
	public void changeId(AuthInfo authInfo, String newId, HttpServletRequest request) throws Exception {
		Member member = memberDAO.selectMemberById(authInfo.getMemberId());
		memberDAO.requestEmailUpdate(authInfo.getMemberId());

		mailSendService.sendMail(from_addr, from_name, newId, member.getMemberName(), request, true, member.getMemberNumber());
	}

	@Transactional(rollbackFor = SQLException.class)
	public void updateId(ChangeIdCommand changeIdCommand) {
		memberDAO.updateId(changeIdCommand);
	}

}
