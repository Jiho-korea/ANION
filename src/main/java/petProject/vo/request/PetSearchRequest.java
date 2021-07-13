/*
========================================================================
파    일    명 : PetSearchRequest.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.12
작  성  내  용 : 검색 단어와 페이지 넘버를 담는 vo
========================================================================
*/
package petProject.vo.request;

import org.hibernate.validator.constraints.NotBlank;

public class PetSearchRequest {

	@NotBlank
	private String petKindWord;
	private Integer pageNumber;

	public PetSearchRequest() {
		super();
	}

	public PetSearchRequest(String petKindWord, Integer pageNumber) {
		super();
		this.petKindWord = petKindWord;
		this.pageNumber = pageNumber;
	}

	public String getPetKindWord() {
		return petKindWord;
	}

	public void setPetKindWord(String petKindWord) {
		this.petKindWord = petKindWord;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

}
