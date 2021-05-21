/*
========================================================================
파    일    명 : EmailcodeDeleteService
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.04.30
작  성  내  용 : Emailcode 데이터 삭제 클래스
========================================================================
*/
package petProject.service.member;

import petProject.vo.dto.Emailcode;

public interface EmailcodeDeleteService {

	void deleteEmailcode(Emailcode emailcode);

	void deleteEmailcode(String newMemberId);
}
