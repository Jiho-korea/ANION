/*
========================================================================
파    일    명 : ImgpostAndImage.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : ImgpostAndImage DTO 객체
========================================================================
*/
package petProject.vo.dto;

import java.util.List;

import petProject.vo.Image;

public class ImgpostAndImage {

	private static final long serialVersionUID = 1L;
	private int imgpostAndImageId;
	private int imgpostNo;
	private int imageNumber;
	private Imgpost imgpost;
	private List<Image> Images;

	public ImgpostAndImage(int imgpostAndImageId, int imgpostNo, int imageNumber, Imgpost imgpost, List<Image> images) {
		super();
		this.imgpostAndImageId = imgpostAndImageId;
		this.imgpostNo = imgpostNo;
		this.imageNumber = imageNumber;
		this.imgpost = imgpost;
		Images = images;
	}

	public ImgpostAndImage() {
		super();
	}

	public int getImgpostAndImageId() {
		return imgpostAndImageId;
	}

	public void setImgpostAndImageId(int imgpostAndImageId) {
		this.imgpostAndImageId = imgpostAndImageId;
	}

	public int getImgpostNo() {
		return imgpostNo;
	}

	public void setImgpostNo(int imgpostNo) {
		this.imgpostNo = imgpostNo;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public Imgpost getImgpost() {
		return imgpost;
	}

	public void setImgpost(Imgpost imgpost) {
		this.imgpost = imgpost;
	}

	public List<Image> getImages() {
		return Images;
	}

	public void setImages(List<Image> images) {
		Images = images;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
