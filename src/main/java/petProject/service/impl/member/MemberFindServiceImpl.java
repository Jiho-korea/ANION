package petProject.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.service.member.MemberFindService;
import petProject.vo.dto.MemberIdProfile;

@Service("memberFindService")
@Transactional
public class MemberFindServiceImpl implements MemberFindService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public MemberIdProfile checkId(String memberId) throws Exception {
		MemberIdProfile memberIdProfile = memberDAO.checkId(memberId);

		if (memberIdProfile == null) {
			throw new MemberNotFoundException("Invalid memberId");
		}
		return memberIdProfile;
	}

}
