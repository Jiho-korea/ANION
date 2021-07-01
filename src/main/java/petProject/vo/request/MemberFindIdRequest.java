package petProject.vo.request;

import org.hibernate.validator.constraints.NotBlank;

public class MemberFindIdRequest {

	@NotBlank
	private String memberName;
	@NotBlank
	private String memberPhoneNumber;

	public MemberFindIdRequest() {
		super();
	}

	public MemberFindIdRequest(String memberName, String memberPhoneNumber) {
		super();
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

}
