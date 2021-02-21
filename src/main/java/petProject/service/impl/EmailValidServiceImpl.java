package petProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.EmailcodeDAO;
import petProject.dao.MemberDAO;
import petProject.exception.EmailcodeDeleteException;
import petProject.exception.EmailcodeNotMatchException;
import petProject.exception.EmailcodeNullException;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberIdUpdateException;
import petProject.service.EmailValidService;
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

	@Override
	public void validCode(Emailcode emailcode) throws Exception {
		String data = emailcodeDAO.selectEmailcode(emailcode.getMemberId());
		if (emailcode.getEmailCode().equals("")) {
			System.out.println(emailcode.getEmailCode() + "-");
			throw new EmailcodeNullException("emailcode is null");
		}

		if (data.equals(emailcode.getEmailCode())) {
			int cnt = memberDAO.updateAuthStatus(emailcode.getMemberId());
			if (cnt == 0) {
				throw new MemberAuthUpdateException("Auth Update Exception");
			}
		} else {
			throw new EmailcodeNotMatchException("emailcode not match");
		}
	}

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
	public int valid(Emailcode emailcode) throws Exception {
		int result = 0;
		this.validCode(emailcode);

		String newMemberId = emailcodeDAO.selectNewMemberId(emailcode);
		if (newMemberId != null) {
			emailcode.setNewMemberId(newMemberId);
			this.updateEmail(emailcode);

			result = 1;
		}

		int cnt = emailcodeDAO.doneEmailcode(emailcode);
		if (cnt == 0) {
			throw new EmailcodeDeleteException("invalid memberId");
		}

		return result;
	}
}
