/*
========================================================================
파    일    명 : ImageBoardRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 목록 조회 시 이동하려는 페이지, 검색 제목을 담는 VO객체
========================================================================
*/
package petProject.vo.request;

public class ImageBoardRequest {
	private Integer pageNumber;
	private String imgpostTitle;

	public ImageBoardRequest(Integer pageNumber, String imgpostTitle) {
		super();
		this.pageNumber = pageNumber;
		this.imgpostTitle = imgpostTitle;
	}

	public ImageBoardRequest() {
		super();
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getImgpostTitle() {
		return imgpostTitle;
	}

	public void setImgpostTitle(String imgpostTitle) {
		this.imgpostTitle = imgpostTitle;
	}

}
