/*
========================================================================
파    일    명 : PetInfoUpdateException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Pet Info Update시 예외 처리 클래스
========================================================================
*/
package petProject.exception;

public class PetInfoUpdateException extends RuntimeException {
	public PetInfoUpdateException(String message) {
		super(message);
	}
}
