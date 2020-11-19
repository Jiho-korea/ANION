/*
========================================================================
파    일    명 : MemberRegisterRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자로부터 입력받은 정보를 담은 vo 클래스
========================================================================
*/
package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class MemberRegisterRequest {
	@NotBlank
	private String memberId;
	@NotBlank
	private String memberPassword;
	@NotBlank
	private String checkPassword;
	@NotBlank
	private String memberName;
	@NotBlank
	private String memberPhoneNumber;

	public MemberRegisterRequest(String memberId, String memberPassword, String checkPassword, String memberName,
			String memberPhoneNumber) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.checkPassword = checkPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public MemberRegisterRequest() {
		super();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
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
	
	public boolean isPasswordEqualToCheckPassword() {
		return memberPassword.equals(checkPassword);
	}
}
