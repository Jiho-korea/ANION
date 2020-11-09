/*
========================================================================
파    일    명 : OwnerDAO.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자를 구분하는 메서드 선언 인터페이스
========================================================================
*/
package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.LoginRequest;
import petProject.vo.Owner;

// owner 테이블에 접근하는 DAO
@Mapper
public interface OwnerDAO {
	Owner selectByIdPassword(@Param("loginRequest") LoginRequest loginRequest) throws Exception;
}
