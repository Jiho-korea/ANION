/*
========================================================================
파    일    명 : EmailcodeNotMatchException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : emailcode 일치하지 않을때 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class EmailcodeNotMatchException extends RuntimeException {
	public EmailcodeNotMatchException(String message) {
		super(message);
	}
}
