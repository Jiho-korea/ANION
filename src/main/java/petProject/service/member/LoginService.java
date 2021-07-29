/*
========================================================================
파    일    명 : LoginService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Id와 PW를 통해 사용자를 검색하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.member;

import petProject.vo.AuthInfo;

public interface LoginService {
	AuthInfo selectMemberById(String memberId, String memberPassword) throws Exception;

	void selectById(String memberId) throws Exception;
}
