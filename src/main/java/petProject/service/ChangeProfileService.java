package petProject.service;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.Member;

public interface ChangeProfileService {

	void updateName(AuthInfo authInfo, String memberName) throws Exception;

	void changeId(AuthInfo authInfo, String newId, HttpServletRequest request) throws Exception;
	
	void updateId(ChangeIdCommand changeIdCommand);

}
