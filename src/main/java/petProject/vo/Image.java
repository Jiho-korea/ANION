/*
========================================================================
파    일    명 : Image.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Image의 정보를 담은 vo 클래스
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.06
수  정  내  용 : Pet과 Member를 연관조회 할 수 있도록 VO 필드 추가
========================================================================
*/
package petProject.vo;

public class Image {
	private static final long serialVersionUID = 1L;
	private int petRegistrationNumber;
	private String imagePath;
	private int memberNumber;
	private int imageNumber;
	private Pet pet;
	private Member member;

	public Image(int petRegistrationNumber, String imagePath, int memberNumber, int imageNumber, Pet pet,
			Member member) {
		super();
		this.petRegistrationNumber = petRegistrationNumber;
		this.imagePath = imagePath;
		this.memberNumber = memberNumber;
		this.imageNumber = imageNumber;
		this.pet = pet;
		this.member = member;
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

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
