/*
========================================================================
파    일    명 : ChangeNameCommand.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : Name을 변경하기위한 vo
========================================================================
*/

package petProject.vo.request;

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
