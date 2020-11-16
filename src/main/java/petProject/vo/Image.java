/*
========================================================================
파    일    명 : Image.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Image의 정보를 담은 vo 클래스
========================================================================
*/
package petProject.vo;

public class Image {
	private static final long serialVersionUID = 1L;
	private int petRegistrationNumber;
	private String imagePath;
	private String memberId;
	private int imageNumber;

	public Image(int petRegistrationNumber, String imagePath, String memberId, int imageNumber) {
		super();
		this.petRegistrationNumber = petRegistrationNumber;
		this.imagePath = imagePath;
		this.memberId = memberId;
		this.imageNumber = imageNumber;
	}

	public Image() {
		super();
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
