/*
========================================================================
파    일    명 : ChangePasswordService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : 비밀번호 변경 service
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.07.03
수  정  내  용 : 임시 비밀번호로 변경하는 메소드 추가
========================================================================
*/

package petProject.service.member;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.dto.MemberIdProfile;

public interface ChangePasswordService {

	void changePassword(String memberId, String oldPassword, String newPassword) throws Exception;

	void updateTempPassword(MemberIdProfile memberIdProfile, String tempPassword, HttpServletRequest request,
			boolean isHtml) throws Exception;
}
