/*
========================================================================
파    일    명 : NonExistentPageException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 존재하지 않는 페이지로 이동할 때 발생하는 예외
========================================================================
*/
package petProject.exception;

public class NonExistentPageException extends RuntimeException {

	public NonExistentPageException(String message) {
		super(message);
	}

}
