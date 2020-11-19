/*
========================================================================
파    일    명 : Member.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자의 정보를 담는 vo 클래스
========================================================================
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.xx.xx
수  정  내  용 : 생성자 매개변수 수정
========================================================================
*/
package petProject.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private int memberLevel;
	private int memberAuthStatus;


	public Member(String memberId, String memberPassword, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, int memberLevel, int memberAuthStatus) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberLevel = memberLevel;
		this.memberAuthStatus = memberAuthStatus;
	}

	public Member() {
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

	public boolean matchPassword(String memberPassword) {
		return this.memberPassword.contentEquals(memberPassword);
	}
}
