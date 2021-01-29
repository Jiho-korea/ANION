package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class ChangeIdCommand {

	@NotBlank
	private String memberId;
	private int memberNumber;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

}
