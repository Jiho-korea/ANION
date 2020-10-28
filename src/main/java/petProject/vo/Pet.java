package petProject.vo;

import java.io.Serializable;

public class Pet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ownerId;
	private String petName;
	private String petKind;
	private String petBirthday;
	private int petRegistrationNumber;
	private String petRegistrationDate;
	private String petMicrochip;
	private String petMothername;
	private String petFathername;
	private String petSex;

	public Pet(String ownerId, String petName, String petKind, String petBirthday, int petRegistrationNumber,
			String petRegistrationDate, String petMicrochip, String petMothername, String petFathername,
			String petSex) {
		super();
		this.ownerId = ownerId;
		this.petName = petName;
		this.petKind = petKind;
		this.petBirthday = petBirthday;
		this.petRegistrationNumber = petRegistrationNumber;
		this.petRegistrationDate = petRegistrationDate;
		this.petMicrochip = petMicrochip;
		this.petMothername = petMothername;
		this.petFathername = petFathername;
		this.petSex = petSex;
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

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
