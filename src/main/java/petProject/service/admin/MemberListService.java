/*
========================================================================
파    일    명 : MemberListService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Member 리스트를 가져오는 서비스 인터페이스
========================================================================
*/
package petProject.service.admin;

import java.util.List;

import petProject.vo.dto.Member;

public interface MemberListService {
	List<Member> selectMemberList() throws Exception;

	int selectMemberCount() throws Exception;

	int selectPetCount() throws Exception;

	int selectImageCount() throws Exception;

}
