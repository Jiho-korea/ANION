/*
========================================================================
파    일    명 : MemberValidServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.08.04
작  성  내  용 : 회원상태를 통해 회원 검증
========================================================================
*/
package petProject.service.impl.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.service.member.MemberValidService;

@Service
@Transactional(rollbackFor = SQLException.class)
public class MemberValidServiceImpl implements MemberValidService {

	@Autowired
	MemberDAO memberDAO;

	//한시간마다 memberAuthStatusValid메서드를 실행
	@Override
	@Scheduled(fixedDelay=1000*60*60)
	public void memberAuthStatusValid() {
		memberDAO.memberAuthStatusValid();
	}


}