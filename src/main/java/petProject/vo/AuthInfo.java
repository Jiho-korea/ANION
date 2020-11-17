/*
========================================================================
파    일    명 : AuthInfo.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.16
작  성  내  용 : 세션에 담길 정보
========================================================================
*/
package petProject.vo;

import java.util.Date;

public class AuthInfo {
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private int memberLevel;
	private int memberAuthStatus;

	public AuthInfo(String memberId, String memberName, String memberPhoneNumber, Date memberRegisterDate,
			int memberLevel, int memberAuthStatus) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberLevel = memberLevel;
		this.memberAuthStatus = memberAuthStatus;
	}

	public AuthInfo() {
		super();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public Date getMemberRegisterDate() {
		return memberRegisterDate;
	}

	public void setMemberRegisterDate(Date memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public int getMemberAuthStatus() {
		return memberAuthStatus;
	}

	public void setMemberAuthStatus(int memberAuthStatus) {
		this.memberAuthStatus = memberAuthStatus;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
