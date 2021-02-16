/*
========================================================================
파    일    명 : MemberDuplicateException.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.20
작  성  내  용 : 이메일 중복 익셉션 정의
========================================================================
*/
package petProject.exception;

public class EmailcodeInsertException extends RuntimeException {
	public EmailcodeInsertException(String message) {
		super(message);
	}
}
