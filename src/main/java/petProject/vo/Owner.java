package petProject.vo;

import java.io.Serializable;

public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ownerId;
	private String ownerPassword;

	public Owner(String ownerId, String ownerPassword) {
		super();
		this.ownerId = ownerId;
		this.ownerPassword = ownerPassword;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
