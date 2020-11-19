/*
========================================================================
파    일    명 : MemberRegisterService
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
수    정    자 : 송찬영, 임원석
수    정    일 : 2020.11.17
수  정  내  용 : 이메일 인증 메소드 선언
========================================================================

*/
package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.MemberRegisterRequest;

public interface MemberRegisterService {
	int insertMember(@Param("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest) throws Exception;

	int selectById(@Param("memberRegisterRequest") String memberId) throws Exception;
	
	int updateAuthStatus(@Param("memberId") String memberId) throws Exception;
}
