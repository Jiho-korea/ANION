/*
========================================================================
파    일    명 : MemberWithdrawalException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : 익셉션 클래스
========================================================================
*/
package petProject.exception;

public class MemberWithdrawalException extends RuntimeException {
	public MemberWithdrawalException(String message) {
		super(message);
	}
}
