/*
========================================================================
파    일    명 : MemberWithdrawalDAO.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : withdrawal 테이블을 이용하는 메소드
========================================================================
*/
package petProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.request.MemberWithdrawalRequest;

@Mapper
public interface MemberWithdrawalDAO {

	int insertComment(@Param("memberWithdrawalRequest") MemberWithdrawalRequest memberWithdrawalRequest);

	int deleteMemberWithdrawal(@Param("memberNumber") int memberNumber);

}
