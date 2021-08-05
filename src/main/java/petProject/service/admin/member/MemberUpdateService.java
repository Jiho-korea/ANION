/*
========================================================================
파    일    명 : MemberUpdateService.java
========================================================================
작    성    자 : 정세진
작    성    일 : 2021.08.03
작  성  내  용 : 회원정보 수정 service
========================================================================
*/

package petProject.service.admin.member;

import petProject.vo.request.ChangeNameCommand;

public interface MemberUpdateService {

	void updateName(ChangeNameCommand changeNameCommand) throws Exception;

}
