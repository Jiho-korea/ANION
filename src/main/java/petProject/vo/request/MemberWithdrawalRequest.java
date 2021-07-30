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
	private String comment;
	private Date withdrawalDate;

	public MemberWithdrawalRequest(int memberNumber, String comment, Date withdrawalDate) {
		super();
		this.memberNumber = memberNumber;
		this.comment = comment;
		this.withdrawalDate = withdrawalDate;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(Date withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

}
