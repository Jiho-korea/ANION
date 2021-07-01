package petProject.service.member;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.MemberIdProfile;
import petProject.vo.request.MemberFindIdRequest;

public interface MemberFindService {
	MemberIdProfile findId(@Param("memberFindRequest") MemberFindIdRequest memberFindIdRequest) throws Exception;

	String checkId(@Param("memberId") String memberId) throws Exception;
	
}
