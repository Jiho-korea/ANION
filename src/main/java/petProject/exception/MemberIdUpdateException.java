/*
========================================================================
파    일    명 : MemberIdUpdateException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : Member Id Update시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class MemberIdUpdateException extends RuntimeException {
	public MemberIdUpdateException(String message) {
		super(message);
	}
}
