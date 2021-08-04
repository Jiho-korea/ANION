/*
========================================================================
파    일    명 : MemberWithdrawalRequest.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : 회원탈퇴 request vo
========================================================================
*/
package petProject.vo.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class MemberWithdrawalRequest {

	@NotBlank
	private int memberNumber;
	private String memberWithdrawalComment;
	private Date memberWithdrawalDate;

	public MemberWithdrawalRequest(int memberNumber, String memberWithdrawalComment, Date memberWithdrawalDate) {
		super();
		this.memberNumber = memberNumber;
		this.memberWithdrawalComment = memberWithdrawalComment;
		this.memberWithdrawalDate = memberWithdrawalDate;
	}

	public MemberWithdrawalRequest() {
		super();
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberWithdrawalComment() {
		return memberWithdrawalComment;
	}

	public void setMemberWithdrawalComment(String memberWithdrawalComment) {
		this.memberWithdrawalComment = memberWithdrawalComment;
	}

	public Date getMemberWithdrawalDate() {
		return memberWithdrawalDate;
	}

	public void setMemberWithdrawalDate(Date memberWithdrawalDate) {
		this.memberWithdrawalDate = memberWithdrawalDate;
	}

}
