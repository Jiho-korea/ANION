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
