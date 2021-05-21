/*
========================================================================
파    일    명 : PetDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : pet등록, 목록 불러오기 관련 메서드 선언 인터페이스
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.01.28
수  정  내  용 : 반려견 이름 수정 메소드 추가
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Pet;
import petProject.vo.request.PetNameUpdateRequest;
import petProject.vo.request.PetRegisterRequest;

// DB PET 테이블에 접근하는  DAO
@Mapper
public interface PetDAO {
	int insertPet(@Param("petRegisterRequest") PetRegisterRequest petRegisterRequest) throws Exception;

	int selectCurrval() throws Exception;

	int selectPetCount() throws Exception;

	List<Pet> selectPetList(@Param("memberNumber") int memberNumber) throws Exception;

	Pet selectPet(@Param("petRegistrationNumber") int petRegistrationNumber) throws Exception;

	int updatePetName(@Param("petNameUpdateRequest") PetNameUpdateRequest petNameUpdateRequest) throws Exception;

}
