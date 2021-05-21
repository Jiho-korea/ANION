/*
========================================================================
파    일    명 : Memberauth.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : memberauth 테이블의 vo객체
========================================================================
*/
package petProject.vo.dto;

public class Memberauth {

	private int memberAuthStatus;
	private String memberStatus;

	public int getMemberAuthStatus() {
		return memberAuthStatus;
	}

	public void setMemberAuthStatus(int memberAuthStatus) {
		this.memberAuthStatus = memberAuthStatus;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

}
