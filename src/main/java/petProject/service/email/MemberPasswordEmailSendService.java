/*
========================================================================
파    일    명 : MemberPasswordEmailSendService.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : MemberIdProfile vo와 임시 비밀번호를 발급받아 mailsendservice를 이용하는 서비스
========================================================================
*/
package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

import petProject.vo.dto.Member;

public interface MemberPasswordEmailSendService {

   boolean sendPassword(Member member, String tempPassword, HttpServletRequest request,
         boolean isHtml) throws Exception;

}