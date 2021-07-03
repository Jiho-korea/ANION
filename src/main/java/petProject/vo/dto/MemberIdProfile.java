/*
========================================================================
파    일    명 : MemberIdProfile.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2020.07.03
작  성  내  용 : id, name, registrationDate의 필드를 갖는 클래스
========================================================================
*/
package petProject.vo.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class MemberIdProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String memberId;
	private String memberName;
	private Date memberRegistrationDate;

	public MemberIdProfile() {
		super();
	}

	public MemberIdProfile(String memberId, String memberName, Date memberRegistrationDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberRegistrationDate = memberRegistrationDate;
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

	public Date getMemberRegistrationDate() {
		return memberRegistrationDate;
	}

	public void setMemberRegistrationDate(Date memberRegistrationDate) {
		this.memberRegistrationDate = memberRegistrationDate;
	}

}