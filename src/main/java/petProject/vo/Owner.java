package petProject.vo;

import java.io.Serializable;
import java.util.Date;

public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ownerId;
	private String ownerPassword;
	private String ownerName;
	private String ownerPhoneNumber;
	private Date ownerRegisterDate;
	private int memberLevel;

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}

	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		this.ownerPhoneNumber = ownerPhoneNumber;
	}

	public Date getOwnerRegisterDate() {
		return ownerRegisterDate;
	}

	public void setOwnerRegisterDate(Date ownerRegisterDate) {
		this.ownerRegisterDate = ownerRegisterDate;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Owner(String ownerId, String ownerPassword) {
		super();
		this.ownerId = ownerId;
		this.ownerPassword = ownerPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
