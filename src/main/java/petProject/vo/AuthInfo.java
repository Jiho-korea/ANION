/*
========================================================================
파    일    명 : AuthInfo.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.16
작  성  내  용 : 세션에 담길 정보
========================================================================
수    정    자 : 송찬영, 강지호
수    정    일 : 2020.11.24
수  정  내  용 : 연관조회를 위한 vo객체 필드로 선언
========================================================================
*/
package petProject.vo;

import java.util.Date;

import petProject.vo.dto.Memberauth;
import petProject.vo.dto.Memberlevel;

public class AuthInfo {
	private static final long serialVersionUID = 1L;
	private String memberId;
	private int memberNumber;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private Memberlevel memberlevel;
	private Memberauth memberauth;

	public AuthInfo() {
		super();
	}

	public AuthInfo(String memberId, int memberNumber, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, Memberlevel memberlevel, Memberauth memberauth) {
		super();
		this.memberId = memberId;
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberlevel = memberlevel;
		this.memberauth = memberauth;
	}

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

	public Memberlevel getMemberlevel() {
		return memberlevel;
	}

	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}

	public Memberauth getMemberauth() {
		return memberauth;
	}

	public void setMemberauth(Memberauth memberauth) {
		this.memberauth = memberauth;
	}

}