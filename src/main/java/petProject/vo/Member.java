/*
========================================================================
파    일    명 : Member.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자의 정보를 담는 vo 클래스
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.xx.xx
수  정  내  용 : 생성자 매개변수 수정
========================================================================
수    정    자 : 송찬영, 강지호
수    정    일 : 2020.11.24
수  정  내  용 : 연관조회를 위해 vo객체를 필드로 선언
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
	private int memberAuthStatus;
	private int memberNumber;
	private Memberlevel memberlevel;

	public Member(String memberId, String memberPassword, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, int memberAuthStatus, int memberNumber, Memberlevel memberlevel) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberAuthStatus = memberAuthStatus;
		this.memberNumber = memberNumber;
		this.memberlevel = memberlevel;
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

	public int getMemberAuthStatus() {
		return memberAuthStatus;
	}

	public void setMemberAuthStatus(int memberAuthStatus) {
		this.memberAuthStatus = memberAuthStatus;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public Memberlevel getMemberlevel() {
		return memberlevel;
	}

	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}