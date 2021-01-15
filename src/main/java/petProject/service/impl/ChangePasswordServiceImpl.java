package petProject.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.exception.WrongIdPasswordException;
import petProject.service.ChangePasswordService;
import petProject.vo.Member;

@Service("changePasswordService")
@Component
public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberDAO memberDAO;

	@Transactional(rollbackFor=SQLException.class)
	public void changePassword(String memberId, String oldPassword, String newPassword) throws Exception {
		Member member = memberDAO.selectMemberById(memberId);
		if(member == null) {
			throw new MemberNotFoundException("NOT FOUND");
		}
		
		if (!passwordEncoder.matches(oldPassword, member.getMemberPassword()))
			throw new WrongIdPasswordException("not Matching");
		
		member.setMemberPassword(passwordEncoder.encode(newPassword));
		
		memberDAO.updatePassword(member);
	}

}
