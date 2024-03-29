/*
========================================================================
파    일    명 : MemberRegisterEmailService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 회원가입 확인 이메일 서비스 인터페이스 
========================================================================
*/
package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;

public interface MemberRegisterEmailService {
	public boolean createMemberRegisterEmail(Emailcode emailcode, Member member, HttpServletRequest request,
			boolean isHtml) throws Exception;
}
