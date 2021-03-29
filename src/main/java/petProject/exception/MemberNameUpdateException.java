/*
========================================================================
파    일    명 : MemberNameUpdateException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : MemberName 변경시 발생하는 Exception
========================================================================
*/
package petProject.exception;

public class MemberNameUpdateException extends RuntimeException {
	public MemberNameUpdateException(String message) {
		super(message);
	}
}
