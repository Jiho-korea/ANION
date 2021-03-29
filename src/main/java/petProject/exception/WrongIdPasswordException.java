/*
========================================================================
파    일    명 : WrongIdPasswordException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : ID, Password 불일치시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class WrongIdPasswordException extends RuntimeException {
	public WrongIdPasswordException(String message) {
		super(message);
	}
}
