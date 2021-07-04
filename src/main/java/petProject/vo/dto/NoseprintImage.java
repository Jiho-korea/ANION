/*
========================================================================
파    일    명 : NoseprintImage.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : noseprint_image 테이블의 정보를 담은 vo 클래스
========================================================================
*/
package petProject.vo.dto;

public class NoseprintImage {
	private static final long serialVersionUID = 1L;
	private int petRegistrationNumber;
	private String noseprintImagePath;
	private int memberNumber;
	private int noseprintImageNumber;
	private int noseprintImageAuthStatus;
	private Pet pet;
	private Member member;

	public NoseprintImage(int petRegistrationNumber, String noseprintImagePath, int memberNumber,
			int noseprintImageNumber, int noseprintImageAuthStatus, Pet pet, Member member) {
		super();
		this.petRegistrationNumber = petRegistrationNumber;
		this.noseprintImagePath = noseprintImagePath;
		this.memberNumber = memberNumber;
		this.noseprintImageNumber = noseprintImageNumber;
		this.noseprintImageAuthStatus = noseprintImageAuthStatus;
		this.pet = pet;
		this.member = member;
	}

	public NoseprintImage() {
		super();
	}

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public String getNoseprintImagePath() {
		return noseprintImagePath;
	}

	public void setNoseprintImagePath(String noseprintImagePath) {
		this.noseprintImagePath = noseprintImagePath;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getNoseprintImageNumber() {
		return noseprintImageNumber;
	}

	public void setNoseprintImageNumber(int noseprintImageNumber) {
		this.noseprintImageNumber = noseprintImageNumber;
	}

	public int getNoseprintImageAuthStatus() {
		return noseprintImageAuthStatus;
	}

	public void setNoseprintImageAuthStatus(int noseprintImageAuthStatus) {
		this.noseprintImageAuthStatus = noseprintImageAuthStatus;
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
