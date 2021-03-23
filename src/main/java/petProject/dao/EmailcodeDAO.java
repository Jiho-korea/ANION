/*
========================================================================
파    일    명 : EmailcodeDAO.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : Emailcode 테이블을 이용하는 메서드
========================================================================
*/
package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.Emailcode;

@Mapper
public interface EmailcodeDAO {

	Emailcode selectEmailcode(@Param("emailcode") Emailcode emailcode);

	int insertEmailcode(@Param("emailcode") Emailcode emailcode) throws Exception;

	int updateEmailcode(@Param("emailcode") Emailcode emailcode);

	int requestEmailUpdate(@Param("memberId") String memberId);

	int doneEmailcode(@Param("emailcode") Emailcode emailcode);

}
