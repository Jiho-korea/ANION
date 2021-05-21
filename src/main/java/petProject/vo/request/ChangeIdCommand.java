/*
========================================================================
파    일    명 : ChangeIdCommand.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : ID를 변경하기위한 vo
========================================================================
*/

package petProject.vo.request;

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
