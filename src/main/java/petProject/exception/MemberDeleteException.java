/*
========================================================================
파    일    명 : MemberDeleteException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : member delete시 발생하는 exception
========================================================================
*/
package petProject.exception;

public class MemberDeleteException extends RuntimeException {
	public MemberDeleteException(String message) {
		super(message);
	}
}
