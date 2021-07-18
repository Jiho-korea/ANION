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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.ImageDAO;
import petProject.dao.MemberDAO;
import petProject.dao.PetDAO;
import petProject.service.admin.member.MemberListService;
import petProject.vo.dto.Member;

@Service("memberListService")
@Transactional
public class MemberListServiceImpl implements MemberListService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private PetDAO petDAO;

	@Autowired
	private ImageDAO imageDAO;

	@Override
	public List<Member> selectMemberList() throws Exception {
		List<Member> memberList = memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public int selectMemberCount() throws Exception {
		return memberDAO.selectMemberCount();
	}

	@Override
	public int selectPetCount() throws Exception {
		return petDAO.selectPetCount();
	}

	@Override
	public int selectImageCount() throws Exception {
		return imageDAO.selectImageCount();
	}

}
