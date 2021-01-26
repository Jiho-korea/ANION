package petProject.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.service.ChangeIdService;
import petProject.vo.AuthInfo;
import petProject.vo.Member;

@Service("changeIdService")
@Component
public class ChangeIdServiceImpl implements ChangeIdService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Transactional(rollbackFor=SQLException.class)
	public void changeId(AuthInfo authInfo, String newId) throws Exception {
		Member member = memberDAO.selectMemberById(authInfo.getMemberId());
		
		member.setMemberId(newId);
		authInfo.setMemberId(newId);
		
		memberDAO.updateId(member);
	}

}
