/*
========================================================================
파    일    명 : PetNameUpdateRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.28
작  성  내  용 : 반려견 이름 변경 vo 클래스
========================================================================
*/
package petProject.vo.request;

import org.hibernate.validator.constraints.NotBlank;

public class PetNameUpdateRequest {

	private static final long serialVersionUID = 1L;

	private int petRegistrationNumber;
	@NotBlank
	private String petName;

	public PetNameUpdateRequest(int petRegistrationNumber, String petName) {
		super();
		this.petRegistrationNumber = petRegistrationNumber;
		this.petName = petName;
	}

	public PetNameUpdateRequest() {
		super();
	}

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
