package petProject.service.member;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.MemberIdProfile;

public interface MemberFindService {
	
	MemberIdProfile checkId(@Param("memberId") String memberId) throws Exception;
	
}
