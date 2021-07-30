/*
========================================================================
파    일    명 : MemberDeleteService.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2021.07.30
작  성  내  용 : Member를 delete 서비스 인터페이스
========================================================================
*/
package petProject.service.admin.member;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Member;

public interface MemberDeleteService {
	void deleteMember(@Param("memberNumber") int memberNumber) throws Exception;
}
