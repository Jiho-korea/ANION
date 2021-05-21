/*
========================================================================
파    일    명 : ChangePasswordService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : 비밀번호 변경 service
========================================================================
*/

package petProject.service.member;

public interface ChangePasswordService {

	void changePassword(String memberId, String oldPassword, String newPassword) throws Exception;
}
