/*
========================================================================
파    일    명 : PetRegisterException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Pet 등록시 발생하는 예외 처리 클래스
========================================================================
*/
package petProject.exception;

public class PetRegisterException extends RuntimeException {
	public PetRegisterException(String message) {
		super(message);
	}
}
