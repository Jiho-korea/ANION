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
import java.util.List;

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

	// 한시간마다 memberAuthStatusValid메서드를 실행 : 이메일 인증을 하지 않은 사용자는 자동으로 삭제됨
	@Override
	@Scheduled(fixedDelay = 1000 * 60 * 60)
	public void memberAuthStatusValid() {
		memberDAO.memberAuthStatusValid();
	}

	// 한시간마다 memberWithdrawal메서드를 실행 : 7일동안 회원탈퇴를 신청한 회원은 기존아이디 + memberNumber로 변경됨
	@Override
	@Scheduled(fixedDelay = 1000 * 60 * 60)
	public void memberWithdrawal() {
		List<Integer> memberNumberList = memberDAO.selectMemberNumberByDate();
		for (Integer memberNumber : memberNumberList) {
			memberDAO.updateMemberWithdrawalByMemberNumber(memberNumber);
		}
	}

}