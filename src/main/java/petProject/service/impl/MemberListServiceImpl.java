/*
========================================================================
파    일    명 : PetListServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : petDAO의 selectPetList메서드를 이용하는 서비스
========================================================================
*/
package petProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.service.MemberListService;
import petProject.vo.Member;

@Service("memberListService")
@Transactional
public class MemberListServiceImpl implements MemberListService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<Member> selectMemberList() throws Exception {
		List<Member> memberList = memberDAO.selectMemberList();
		return memberList;
	}

}