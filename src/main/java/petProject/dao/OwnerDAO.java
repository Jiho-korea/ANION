/*
========================================================================
파    일    명 : OwnerDAO
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : owner table 접근 DAO
========================================================================
수    정    자 : 임원석, 정세진
수    정    일 : 2020.11.09
수  정  내  용 : 회원가입 메소드 추가
========================================================================
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 추가
========================================================================
*/

package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.LoginRequest;
import petProject.vo.Owner;
import petProject.vo.OwnerRegisterRequest;

// owner 테이블에 접근하는 DAO
@Mapper
public interface OwnerDAO {
	Owner selectByIdPassword(@Param("loginRequest") LoginRequest loginRequest) throws Exception;

	int insertOwner(@Param("ownerRegisterRequest") OwnerRegisterRequest ownerRegisterRequest) throws Exception;
	
	int selectById(@Param("ownerId")String ownerId) throws Exception;
}
