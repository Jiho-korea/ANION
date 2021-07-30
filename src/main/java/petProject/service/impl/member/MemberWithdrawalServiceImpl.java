/*
========================================================================
파    일    명 : MemberWithdrawalServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : WithdrawalService의 구현 클래스
========================================================================
*/
package petProject.service.impl.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.dao.MemberDAO;
import petProject.dao.MemberWithdrawalDAO;
import petProject.exception.MemberAuthUpdateException;
import petProject.exception.MemberWithdrawalException;
import petProject.service.member.MemberWithdrawalService;
import petProject.vo.request.MemberWithdrawalRequest;

@Service("withdrawalService")
@Transactional
public class MemberWithdrawalServiceImpl implements MemberWithdrawalService {

	@Autowired
	MemberWithdrawalDAO memberWithdrawalDAO;

	@Autowired
	MemberDAO memberDAO;

	// 탈퇴하는 이유를 등록하는 메소드
	@Override
	public void insertComment(MemberWithdrawalRequest memberWithdrawalRequest) {
		int cnt = memberWithdrawalDAO.insertComment(memberWithdrawalRequest);
		if (cnt == 0) {
			throw new MemberWithdrawalException("insert error");
		}
	}

	// member의 authStatus를 3으로 변경
	@Override
	public void updateAuthStatus(int memberNumber) {
		int cnt = memberDAO.updateMemberWithdrawal(memberNumber);
		if (cnt == 0) {
			throw new MemberAuthUpdateException("withdrawal error");
		}
	}

	// withdrawal 테이블 record를 삭제하는 메소드
	@Override
	public void deleteMemberWithdrawal(int memberNumber) {
		int cnt = memberWithdrawalDAO.deleteMemberWithdrawal(memberNumber);
		if (cnt == 0) {
			throw new MemberWithdrawalException("Comment delete error");
		}
	}

	// member의 authStatus를 1로 변경
	@Override
	public void updateMemberWithdrawal(int memberNumber) {
		int cnt = memberDAO.cancelMemberWithdrawal(memberNumber);
		if (cnt == 0) {
			throw new MemberWithdrawalException("Comment delete error");
		}
	}

	@Transactional
	public void requestMemberWithdrawal(MemberWithdrawalRequest memberWithdrawalRequest) {
		this.insertComment(memberWithdrawalRequest);
		this.updateAuthStatus(memberWithdrawalRequest.getMemberNumber());
	}

	@Transactional
	public void cancelMemberWithdrawal(int memberNumber) {
		this.deleteMemberWithdrawal(memberNumber);
		this.updateMemberWithdrawal(memberNumber);
	}

}
