/*
========================================================================
파    일    명 : ChangeProfileService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : Profile 변경 service
========================================================================
*/

package petProject.service.member;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.AuthInfo;
import petProject.vo.ChangeIdCommand;
import petProject.vo.ChangeNameCommand;

public interface ChangeProfileService {

	void updateName(ChangeNameCommand changeNameCommand, AuthInfo authInfo) throws Exception;

	void changeId(ChangeIdCommand changeIdCommand, AuthInfo authInfo, HttpServletRequest request) throws Exception;

	int selectById(String memberId) throws Exception;

}
