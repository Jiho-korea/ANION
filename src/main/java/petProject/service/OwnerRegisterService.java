/*
========================================================================
파    일    명 : OwnerRegisterService
========================================================================
작    성    자 : 임원석, 정세진, 송찬영
작    성    일 : 2020.11.09
작  성  내  용 : 
========================================================================

========================================================================
*/

package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.OwnerRegisterRequest;

public interface OwnerRegisterService {
	int insertOwner(@Param("ownerRegisterRequest") OwnerRegisterRequest ownerRegisterRequest) throws Exception;
}
