/*
========================================================================
파    일    명 : EmailcodeDeleteException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : Emailcode Delete시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class EmailcodeDeleteException extends RuntimeException {
	public EmailcodeDeleteException(String message) {
		super(message);
	}
}
