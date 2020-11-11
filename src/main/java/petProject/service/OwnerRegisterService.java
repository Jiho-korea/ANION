/*
========================================================================
파    일    명 : OwnerRegisterService
========================================================================
작    성    자 : 임원석, 정세진, 송찬영
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 메소드 선언
========================================================================
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 선언
========================================================================
*/

package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Owner;
import petProject.vo.OwnerRegisterRequest;

public interface OwnerRegisterService {
	int insertOwner(@Param("ownerRegisterRequest") OwnerRegisterRequest ownerRegisterRequest) throws Exception;
	
	int selectById(@Param("ownerRegisterRequest")OwnerRegisterRequest ownerRegisterRequest) throws Exception;
}
