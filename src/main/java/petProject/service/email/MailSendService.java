/*
========================================================================
파    일    명 : MailSendService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 이메일 발송 서비스 인터페이스 
========================================================================
*/
package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

public interface MailSendService {

	boolean sendMail(String to_addr, String to_name, String mailHead, String mailContent, HttpServletRequest request,
			boolean isHtml) throws Exception;

}
