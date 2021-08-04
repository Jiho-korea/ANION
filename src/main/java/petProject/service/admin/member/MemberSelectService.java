/*
========================================================================
파    일    명 : MemberSelectService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.17
작  성  내  용 : Member를 select 서비스 인터페이스
========================================================================
*/
package petProject.service.admin.member;

import petProject.vo.dto.Member;

public interface MemberSelectService {
	Member selectMemberByMemberNumber(int memberNumber) throws Exception;
}
