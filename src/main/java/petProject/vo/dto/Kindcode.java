/*
========================================================================
파    일    명 : Kindcode.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode table VO 객체
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.20
작  성  내  용 : 기본 생성자 추가
========================================================================
*/

package petProject.vo.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Kindcode implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank
	private String petKindcode;
	@NotBlank
	private String petKind;
	@NotBlank
	private String petKindHabitat;

	public Kindcode() {
		super();
	}

	public Kindcode(String petKindcode, String petKind, String petKindHabitat) {
		super();
		this.petKindcode = petKindcode;
		this.petKind = petKind;
		this.petKindHabitat = petKindHabitat;
	}

	public String getPetKindcode() {
		return petKindcode;
	}

	public void setPetKindcode(String petKindcode) {
		this.petKindcode = petKindcode;
	}

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public String getPetKindHabitat() {
		return petKindHabitat;
	}

	public void setPetKindHabitat(String petKindHabitat) {
		this.petKindHabitat = petKindHabitat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
