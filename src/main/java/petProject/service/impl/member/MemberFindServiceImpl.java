/*
========================================================================
파    일    명 : MemberFindServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : id를 통해 MemberIdProfile vo를 리턴
========================================================================
*/
package petProject.service.impl.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.service.member.MemberFindService;
import petProject.vo.dto.Member;

@Service("memberFindService")
@Transactional(rollbackFor = SQLException.class)
public class MemberFindServiceImpl implements MemberFindService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public Member selectProfileById(String memberId) throws Exception {
		Member member = memberDAO.selectProfileById(memberId);

		if (member == null) {
			throw new MemberNotFoundException("Invalid memberId");
		}
		return member;
	}

}