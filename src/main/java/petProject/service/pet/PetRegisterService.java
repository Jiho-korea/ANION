/*
========================================================================
파    일    명 : PetRegisterService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : pet 등록하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.service.pet;

import org.apache.ibatis.annotations.Param;

import petProject.vo.request.PetRegisterRequest;

public interface PetRegisterService {
	int insertPet(@Param("petRegisterRequest") PetRegisterRequest petRegisterRequest) throws Exception;
}
