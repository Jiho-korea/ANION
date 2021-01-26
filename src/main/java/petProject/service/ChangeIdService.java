package petProject.service;

import petProject.vo.AuthInfo;

public interface ChangeIdService {

	void changeId(AuthInfo authInfo, String memberId) throws Exception;

}
