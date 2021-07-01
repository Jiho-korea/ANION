package petProject.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.service.member.MemberFindService;
import petProject.vo.dto.MemberIdProfile;
import petProject.vo.request.MemberFindIdRequest;

@Service("memberFindService")
@Transactional
public class MemberFindServiceImpl implements MemberFindService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public MemberIdProfile findId(MemberFindIdRequest memberFindIdRequest) throws Exception {
		MemberIdProfile memberIdProfile = memberDAO.findProfile(memberFindIdRequest);

		if (memberIdProfile == null) {
			throw new MemberNotFoundException("Member Not Found");
		}

		return memberIdProfile;
	}

	@Override
	public String checkId(String memberId) throws Exception {
		String result = memberDAO.checkId(memberId);

		if (result == null) {
			throw new MemberNotFoundException("Invalid memberId");
		}
		return result;
	}

}
