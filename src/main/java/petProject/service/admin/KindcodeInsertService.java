/*
========================================================================
파    일    명 : KindcodeInsertService.java
========================================================================
작    성    자 : 임원석, 강지호
작    성    일 : 2020.11.28
작  성  내  용 : 견종 코드 insert 서비스
========================================================================
*/
package petProject.service.admin;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Kindcode;

public interface KindcodeInsertService {
	int insertKindcode(@Param("kindcode") Kindcode kindcode) throws Exception;

}
