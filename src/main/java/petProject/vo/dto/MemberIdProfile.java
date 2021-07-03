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