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

import petProject.vo.Kindcode;

// DB Kindcode 테이블에 접근하는  DAO
@Mapper
public interface KindcodeDAO {

	List<Kindcode> selectKindcodeList() throws Exception;

	List<Kindcode> selectKindcodeListPage(@Param("pageNumber") Integer pageNumber) throws Exception;

	int insertKindcode(Kindcode kindcode) throws Exception;

	Kindcode selectKindcode(@Param("petKindcode") String petKindcode) throws Exception;

	int updateKindcode(Kindcode kindcode) throws Exception;

	int deleteKindcode(String petKindcode) throws Exception;

	String findKindcode(@Param("petKind") String petKind) throws Exception;
}
