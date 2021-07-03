package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.dto.MemberIdProfile;

public interface MemberPasswordEmailSendService {

	boolean sendPassword(MemberIdProfile memberIdProfile, String tempPassword, HttpServletRequest request,
			boolean isHtml) throws Exception;

}
