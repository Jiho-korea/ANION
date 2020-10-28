package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class PetRegisterRequest {

	private static final long serialVersionUID = 1L;

	private String ownerId;
	@NotBlank
	private String petName;
	@NotBlank
	private String petKind;
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

	public PetRegisterRequest(String ownerId, String petName, String petKind, String petBirthday, String petMothername,
			String petFathername, String petMicrochip, String petSex) {
		super();
		this.ownerId = ownerId;
		this.petName = petName;
		this.petKind = petKind;
		this.petBirthday = petBirthday;
		this.petMothername = petMothername;
		this.petFathername = petFathername;
		this.petMicrochip = petMicrochip;
		this.petSex = petSex;
	}

	public PetRegisterRequest() {
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

}
