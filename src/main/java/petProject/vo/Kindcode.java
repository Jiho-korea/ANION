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

package petProject.vo;

import java.io.Serializable;

public class Kindcode implements Serializable {

	private static final long serialVersionUID = 1L;
	private String petKindcode;
	private String petKind;

	public Kindcode() {
		super();
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

	public Kindcode(String petKindcode, String petKind) {
		super();
		this.petKind = petKind;
		this.petKindcode = petKindcode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
