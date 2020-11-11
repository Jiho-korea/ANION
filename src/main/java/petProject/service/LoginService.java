/*
========================================================================
파    일    명 : LoginService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Id와 PW를 통해 사용자를 검색하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.LoginRequest;
import petProject.vo.Owner;

public interface LoginService {
	Owner selectByIdPassword(@Param("loginRequest") LoginRequest loginRequest) throws Exception;
}
