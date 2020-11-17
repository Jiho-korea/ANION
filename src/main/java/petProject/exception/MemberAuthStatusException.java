/*
========================================================================
파    일    명 : MemberAuthStatusException.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 이메일 인증 미완료시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class MemberAuthStatusException extends RuntimeException {
	public MemberAuthStatusException(String message) {
		super(message);
	}
}
