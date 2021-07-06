/*
========================================================================
파    일    명 : EmailValidService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : 이메일 검증을 위한 메서드 선언 인터페이스
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.05
수  정  내  용 : DB의 authStatus를 통해 접근 불가 검증
========================================================================
*/
package petProject.service.email;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Emailcode;

public interface EmailValidService {

	String valid(@Param("emailcode") Emailcode emailcode) throws Exception;

	Emailcode validCode(@Param("emailcode") Emailcode emailcode) throws Exception;

	void updateEmail(@Param("emailcode") Emailcode emailcode) throws Exception;
	
	void checkMemberAuthStatus(@Param("emailcode") Emailcode emailcode) throws Exception;
}
