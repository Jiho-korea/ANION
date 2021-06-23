package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import petProject.vo.dto.Member;

public interface MemberRegisterEmailService {
	public boolean createMemberRegisterEmail(@Param("member") Member member, HttpServletRequest request, boolean isHtml,
			String emailcode) throws Exception;
}
