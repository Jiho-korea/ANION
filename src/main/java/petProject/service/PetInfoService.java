/*
========================================================================
파    일    명 : PetInfoService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 서비스 인터페이스
========================================================================
*/

package petProject.service;

import org.apache.ibatis.annotations.Param;

import petProject.vo.Pet;

public interface PetInfoService {
	Pet selectPet(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;
}
