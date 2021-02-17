/*
========================================================================
파    일    명 : MemberInsertException.java
========================================================================
작    성    자 : 정세진, 임원석
작    성    일 : 2020.xx.xx
작  성  내  용 : 회원 가입에 실패했을 때 발생하는 Exception
========================================================================
=============================== 함  수  설  명  ===============================

========================================================================
*/
package petProject.exception;

public class MemberNameUpdateException extends RuntimeException {
	public MemberNameUpdateException(String message) {
		super(message);
	}
}
