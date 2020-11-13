/*
========================================================================
파    일    명 : Pet.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : pet table VO 객체
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.09
수  정  내  용 : 반려견의 사진 개수를 저장하는 프로퍼티 추가
========================================================================
*/

package petProject.vo;

import java.io.Serializable;

public class Pet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ownerId;
	private String petName;
	private String petKindcode;
	private String petBirthday;
	private int petRegistrationNumber;
	private String petRegistrationDate;
	private String petMicrochip;
	private String petMothername;
	private String petFathername;
	private String petSex;
	private int imageCount;

	public Pet(String ownerId, String petName, String petKindcode, String petBirthday, int petRegistrationNumber,
			String petRegistrationDate, String petMicrochip, String petMothername, String petFathername, String petSex,
			int imageCount) {
		super();
		this.ownerId = ownerId;
		this.petName = petName;
		this.petKindcode = petKindcode;
		this.petBirthday = petBirthday;
		this.petRegistrationNumber = petRegistrationNumber;
		this.petRegistrationDate = petRegistrationDate;
		this.petMicrochip = petMicrochip;
		this.petMothername = petMothername;
		this.petFathername = petFathername;
		this.petSex = petSex;
		this.imageCount = imageCount;
	}

	public Pet() {
		super();
	}

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

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public String getPetRegistrationDate() {
		return petRegistrationDate;
	}

	public void setPetRegistrationDate(String petRegistrationDate) {
		this.petRegistrationDate = petRegistrationDate;
	}

	public String getPetMicrochip() {
		return petMicrochip;
	}

	public void setPetMicrochip(String petMicrochip) {
		this.petMicrochip = petMicrochip;
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

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
