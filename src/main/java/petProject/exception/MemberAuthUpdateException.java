/*
========================================================================
파    일    명 : MemberAuthUpdateException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : MemberAuth Update시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class MemberAuthUpdateException extends RuntimeException {
	public MemberAuthUpdateException(String message) {
		super(message);
	}
}
