package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class ChangeNameCommand {

	@NotBlank
	private String memberName;
	private int memberNumber;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
