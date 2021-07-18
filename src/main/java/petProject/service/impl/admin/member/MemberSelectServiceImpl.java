/*
========================================================================
파    일    명 : MemberListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.23
작  성  내  용 : 멤버 리스트 갖고 오는 서비스 객체
========================================================================
*/
package petProject.service.impl.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.exception.MemberNotFoundException;
import petProject.service.admin.member.MemberSelectService;
import petProject.vo.dto.Member;

@Service("memberSelectService")
@Transactional
public class MemberSelectServiceImpl implements MemberSelectService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member selectMemberByMemberNumber(int memberNumber) throws Exception {
		Member member = memberDAO.selectMemberByMemberNumber(memberNumber);
		if (member == null) {
			throw new MemberNotFoundException("Invalid memberNumber");
		}
		return member;
	}
}
