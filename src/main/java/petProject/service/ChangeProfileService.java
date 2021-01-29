package petProject.service;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.ChangeNameCommand;
import petProject.vo.Member;

public interface ChangeProfileService {

	void updateName(ChangeNameCommand changeNameCommand, AuthInfo authInfo) throws Exception;

	void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request) throws Exception;
	
	void updateId(ChangeIdCommand changeIdCommand);

}
