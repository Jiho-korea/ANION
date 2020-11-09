/*
========================================================================
파    일    명 : Owner.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자의 정보를 담는 vo 클래스
========================================================================
*/
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
