/*
========================================================================
파    일    명 : NoseprintImageUploadRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : 사용자로부터 입력받은 noseprint_image의 vo객체
========================================================================
*/
package petProject.vo.request;

public class NoseprintImageUploadRequest {

	private static final long serialVersionUID = 1L;

	private int memberNumber;
	private int petRegistrationNumber;
	private String noseprintImagePath;

	public NoseprintImageUploadRequest(int memberNumber, int petRegistrationNumber, String noseprintImagePath) {
		super();
		this.memberNumber = memberNumber;
		this.petRegistrationNumber = petRegistrationNumber;
		this.noseprintImagePath = noseprintImagePath;
	}

	public NoseprintImageUploadRequest() {
		super();
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
