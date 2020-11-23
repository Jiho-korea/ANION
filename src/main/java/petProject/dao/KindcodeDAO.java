/*
========================================================================
파    일    명 : KindcodeDAO.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2020.11.13
작  성  내  용 : kindcode select메서드 작성
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import petProject.vo.Kindcode;

// DB PET 테이블에 접근하는  DAO
@Mapper
public interface KindcodeDAO {

	List<Kindcode> selectKindcodeList() throws Exception;

}
