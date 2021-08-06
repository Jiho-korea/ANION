/*
========================================================================
파    일    명 : MemberWithdrawalService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : 회원탈퇴 서비스(탈퇴 이유, authstatus 변경)
========================================================================
*/
package petProject.service.member;

import petProject.vo.request.MemberWithdrawalRequest;

public interface MemberWithdrawalService {

	void insertComment(MemberWithdrawalRequest memberWithdrawalRequest);

	void updateAuthStatus(int memberNumber);

	void deleteMemberWithdrawal(int memberNumber);

	void updateMemberWithdrawal(int memberNumber);

	void requestMemberWithdrawal(MemberWithdrawalRequest memberWithdrawalRequest);

	void cancelMemberWithdrawal(int memberNumber);
}
