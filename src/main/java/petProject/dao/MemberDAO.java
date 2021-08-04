/*
========================================================================
파    일    명 : MemberDAO
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : member table 접근 DAO
========================================================================
수    정    자 : 임원석, 정세진
수    정    일 : 2020.11.09
수  정  내  용 : 회원가입 메소드 추가
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 아이디 중복확인 메소드 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2020.11.17
수  정  내  용 : 이메일 인증 메소드 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.05
수  정  내  용 : 
========================================================================
*/
package petProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Member;
import petProject.vo.dto.Memberauth;
import petProject.vo.request.ChangeIdCommand;
import petProject.vo.request.MemberRegisterRequest;

//member 테이블에 접근하는 DAO
@Mapper
public interface MemberDAO {
	Member selectMemberById(@Param("memberId") String memberId) throws Exception;

	Member selectMemberByMemberNumber(@Param("memberNumber") int memberNumber);

	int insertMember(@Param("memberRegisterRequest") MemberRegisterRequest memberRegisterRequest) throws Exception;

	int selectByIdFromMember(@Param("memberId") String memberId) throws Exception;

	int selectEmailcodeById(@Param("memberId") String memberId) throws Exception;

	List<Member> selectMemberList() throws Exception;

	int updateAuthStatus(@Param("memberId") String memberId) throws Exception;

	int updatePassword(@Param("member") Member member) throws Exception;

	int updateName(@Param("member") Member member) throws Exception;

	int updateId(@Param("changeIdCommand") ChangeIdCommand changeIdCommand) throws Exception;

	int updateMemberWithdrawal(@Param("memberNumber") int memberNumber);

	int cancelMemberWithdrawal(@Param("memberNumber") int memberNumber);

	int selectMemberCount() throws Exception;

	Memberauth checkMemberAuthStatus(@Param("memberId") String memberId) throws Exception;

	Member selectProfileById(@Param("memberId") String memberId) throws Exception;
	
	int deleteMember(@Param("memberNumber") int memberNumber);

	void memberAuthStatusValid();
}
