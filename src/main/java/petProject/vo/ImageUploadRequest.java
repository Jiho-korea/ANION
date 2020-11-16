/*
========================================================================
파    일    명 : ImageUploadRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자로부터 입력받은 Image의 vo객체
========================================================================
*/
package petProject.vo;

public class ImageUploadRequest {

	private static final long serialVersionUID = 1L;

	private String memberId;
	private int petRegistrationNumber;
	private String imagePath;

	public ImageUploadRequest(String memberId, int petRegistrationNumber, String imagePath) {
		super();
		this.memberId = memberId;
		this.petRegistrationNumber = petRegistrationNumber;
		this.imagePath = imagePath;
	}

	public ImageUploadRequest() {
		super();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
