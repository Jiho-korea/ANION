/*
========================================================================
파    일    명 : EmailcodeInsertException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021. 03. 20
작  성  내  용 : Emailcode Table data 추가할때 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class EmailcodeInsertException extends RuntimeException {
	public EmailcodeInsertException(String message) {
		super(message);
	}
}
