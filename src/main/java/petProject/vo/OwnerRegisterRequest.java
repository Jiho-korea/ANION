package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class OwnerRegisterRequest {
	@NotBlank
	private String ownerId;
	@NotBlank
	private String ownerPassword;
	@NotBlank
	private String ownerName;
	@NotBlank
	private String ownerPhoneNumber;

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

	public OwnerRegisterRequest(String ownerId, String ownerPassword, String ownerName, String ownerPhoneNumber) {
		super();
		this.ownerId = ownerId;
		this.ownerPassword = ownerPassword;
		this.ownerName = ownerName;
		this.ownerPhoneNumber = ownerPhoneNumber;
	}

	public OwnerRegisterRequest() {
		super();
	}

}
