/*
========================================================================
파    일    명 : KindcodeDAO.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.01.05
작  성  내  용 : kindcode update, delete 메서드 작성
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.05
수  정  내  용 : findKindcode 메서드 작성
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Kindcode;
import petProject.vo.request.PetSearchRequest;

// DB Kindcode 테이블에 접근하는  DAO
@Mapper
public interface KindcodeDAO {

	List<Kindcode> selectKindcodeList() throws Exception;

	List<Kindcode> searchPetKindList(@Param("petSearchRequest") PetSearchRequest petSearchRequest) throws Exception;

	Kindcode selectKindcode(@Param("petKindcode") String petKindcode) throws Exception;

	int insertKindcode(@Param("kindCode") Kindcode kindcode) throws Exception;

	String findKindcode(@Param("petKind") String petKind) throws Exception;

	String selectPetKind(@Param("petKindcode") String petKindcode) throws Exception;

	int updateKindcode(@Param("kindCode") Kindcode kindcode) throws Exception;

	int deleteKindcode(String petKindcode) throws Exception;

	List<String> selectCountryCodeList() throws Exception;
}
