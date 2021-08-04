/*
========================================================================
파    일    명 : MemberFindService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : id를 통해 회원인지 확인 후 vo리턴
========================================================================
*/
package petProject.service.member;

import petProject.vo.dto.Member;

public interface MemberFindService {
	
	Member selectProfileById(String memberId) throws Exception;
}