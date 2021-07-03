/*
========================================================================
파    일    명 : MemberFindService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2020.07.03
작  성  내  용 : id를 통해 회원인지 확인 후 vo리턴
========================================================================
*/
package petProject.service.member;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.MemberIdProfile;

public interface MemberFindService {
	
	MemberIdProfile selectProfileById(@Param("memberId") String memberId) throws Exception;
	
}
