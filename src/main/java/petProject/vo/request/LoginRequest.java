/*
========================================================================
파    일    명 : LoginRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자로부터 입력받은 Login정보
========================================================================
*/
package petProject.vo.request;

import org.hibernate.validator.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	private String memberId;

	@NotBlank
	private String memberPassword;

	private boolean memory;

	public LoginRequest(String memberId, String memberPassword, boolean memory) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memory = memory;
	}

	public LoginRequest() {
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

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}
}
