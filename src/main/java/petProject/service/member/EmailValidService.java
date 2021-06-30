/*
========================================================================
파    일    명 : EmailValidService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : 이메일 검증을 위한 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.member;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Emailcode;

public interface EmailValidService {

	void checkMemberAuthStatus(@Param("emailcode") Emailcode emailcode) throws Exception;
	
	String valid(@Param("emailcode") Emailcode emailcode) throws Exception;

	Emailcode validCode(@Param("emailcode") Emailcode emailcode) throws Exception;

	void updateEmail(@Param("emailcode") Emailcode emailcode) throws Exception;
}
