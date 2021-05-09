/*
========================================================================
파    일    명 : ImagePostingRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.05.05
작  성  내  용 : 반려견 사진 자랑 게시물 업로드 시 필요한 정보를 담는 Request객체
========================================================================
*/
package petProject.vo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ImagePostingRequest {

	private static final long serialVersionUID = 1L;

	private int imgpostNo;
	@NotBlank
	private String imgpostTitle;
	private int memberNumber;
	@NotBlank
	@Size(min = 2)
	private String imgpostContent;
	@NotNull
	private int imageNumber;
	@NotNull
	private int petRegistrationNumber;

	public ImagePostingRequest(int imgpostNo, String imgpostTitle, int memberNumber, String imgpostContent,
			int imageNumber, int petRegistrationNumber) {
		super();
		this.imgpostNo = imgpostNo;
		this.imgpostTitle = imgpostTitle;
		this.memberNumber = memberNumber;
		this.imgpostContent = imgpostContent;
		this.imageNumber = imageNumber;
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public ImagePostingRequest() {
		super();
	}

	public int getImgpostNo() {
		return imgpostNo;
	}

	public void setImgpostNo(int imgpostNo) {
		this.imgpostNo = imgpostNo;
	}

	public String getImgpostTitle() {
		return imgpostTitle;
	}

	public void setImgpostTitle(String imgpostTitle) {
		this.imgpostTitle = imgpostTitle;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getImgpostContent() {
		return imgpostContent;
	}

	public void setImgpostContent(String imgpostContent) {
		this.imgpostContent = imgpostContent;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
