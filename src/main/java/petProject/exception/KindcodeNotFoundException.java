/*
========================================================================
파    일    명 : PetNotFoundException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 못 불러올 시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class KindcodeNotFoundException extends RuntimeException {
	public KindcodeNotFoundException(String message) {
		super(message);
	}
}
