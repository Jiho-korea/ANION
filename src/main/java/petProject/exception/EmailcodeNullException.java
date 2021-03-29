/*
========================================================================
파    일    명 : EmailcodeNullException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : Emailcode Null일때 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class EmailcodeNullException extends RuntimeException {
	public EmailcodeNullException(String message) {
		super(message);
	}
}
