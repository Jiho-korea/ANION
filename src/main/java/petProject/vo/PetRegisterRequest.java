/*
========================================================================
파    일    명 : PetRegisterRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자로부터 입력받은 pet 정보를 담은 vo 클래스
========================================================================
*/
package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class PetRegisterRequest {

	private static final long serialVersionUID = 1L;

	private String ownerId;
	@NotBlank
	private String petName;
	@NotBlank
	private String petKindcode;
	@NotBlank
	private String petBirthday;
	@NotBlank
	private String petMothername;
	@NotBlank
	private String petFathername;
	@NotBlank
	private String petMicrochip;
	@NotBlank
	private String petSex;
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetKindcode() {
		return petKindcode;
	}
	public void setPetKindcode(String petKindcode) {
		this.petKindcode = petKindcode;
	}
	public String getPetBirthday() {
		return petBirthday;
	}
	public void setPetBirthday(String petBirthday) {
		this.petBirthday = petBirthday;
	}
	public String getPetMothername() {
		return petMothername;
	}
	public void setPetMothername(String petMothername) {
		this.petMothername = petMothername;
	}
	public String getPetFathername() {
		return petFathername;
	}
	public void setPetFathername(String petFathername) {
		this.petFathername = petFathername;
	}
	public String getPetMicrochip() {
		return petMicrochip;
	}
	public void setPetMicrochip(String petMicrochip) {
		this.petMicrochip = petMicrochip;
	}
	public String getPetSex() {
		return petSex;
	}
	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PetRegisterRequest(String ownerId, String petName, String petKindcode, String petBirthday,
			String petMothername, String petFathername, String petMicrochip, String petSex) {
		super();
		this.ownerId = ownerId;
		this.petName = petName;
		this.petKindcode = petKindcode;
		this.petBirthday = petBirthday;
		this.petMothername = petMothername;
		this.petFathername = petFathername;
		this.petMicrochip = petMicrochip;
		this.petSex = petSex;
	}
	public PetRegisterRequest() {
		super();
	}

	

}
