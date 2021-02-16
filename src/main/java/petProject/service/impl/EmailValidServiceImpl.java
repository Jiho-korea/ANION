package petProject.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberAuthUpdateException;
import petProject.service.ChangeProfileService;
import petProject.service.EmailValidService;
import petProject.service.MemberRegisterService;
import petProject.vo.ChangeIdCommand;
import petProject.vo.Emailcode;
import petProject.vo.Member;

@Service("emailValidService")
@Transactional
public class EmailValidServiceImpl implements EmailValidService {

	@Autowired
	private MemberDAO memberDAO;

	@Resource(name = "emailValidService")
	EmailValidService emailValidService;

	@Resource(name = "memberRegisterService")
	MemberRegisterService memberRegisterService;

	@Resource(name = "changeProfileService")
	ChangeProfileService changeProfileService;

	@Override
	public void validCode(Emailcode emailcode) throws Exception {
		String data = memberDAO.selectCode(emailcode.getMemberId());

		if (data.equals(emailcode.getEmailCode())) {
			memberDAO.updateAuthStatus(emailcode.getMemberId());
			memberDAO.doneEmailCode(emailcode.getMemberId());
		}
	}

	@Override
	public void emailChange(Emailcode emailcode) throws Exception {
		String newMemberId = memberDAO.selectNewMemberId(emailcode.getMemberId());

		if (newMemberId != null) {
			emailcode.setNewMemberId(newMemberId);
			this.validCode(emailcode);

			Member member = memberDAO.selectMemberById(emailcode.getMemberId());

			ChangeIdCommand changeIdCommand = new ChangeIdCommand();

			changeIdCommand.setMemberId(newMemberId);
			changeIdCommand.setMemberNumber(member.getMemberNumber());

			try {
				memberRegisterService.updateAuthStatus(member.getMemberId());
				changeProfileService.updateId(changeIdCommand);
			} catch (MemberAuthUpdateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			this.validCode(emailcode);
		}
	}
}
