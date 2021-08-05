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
import petProject.exception.ImageDeleteException;
import petProject.exception.MemberDeleteException;
import petProject.exception.MemberNotFoundException;
import petProject.service.admin.member.MemberDeleteService;
import petProject.service.admin.member.MemberSelectService;
import petProject.vo.dto.Member;

@Service("memberDeleteService")
@Transactional
public class MemberDeleteServiceImpl implements MemberDeleteService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void deleteMember(int memberNumber) throws Exception {
		int result = memberDAO.deleteMember(memberNumber);
		if (result == 0) {
			throw new MemberDeleteException("memberDeleteException");
		}
	}
}
