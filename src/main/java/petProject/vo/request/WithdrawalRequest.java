package petProject.vo.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class WithdrawalRequest {

	@NotBlank
	private int memberNumber;
	private String comment;
	private Date withdrawalDate;

	public WithdrawalRequest(int memberNumber, String comment, Date withdrawalDate) {
		super();
		this.memberNumber = memberNumber;
		this.comment = comment;
		this.withdrawalDate = withdrawalDate;
	}

	public WithdrawalRequest() {
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
