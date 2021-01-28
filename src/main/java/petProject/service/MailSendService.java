/*
========================================================================
파    일    명 : MailSendService.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 이메일 발송 메소드 선언ㅇ
========================================================================
*/
package petProject.service;

import javax.servlet.http.HttpServletRequest;

public interface MailSendService {

	boolean sendMail(String from_addr, String from_name, String to_addr, String to_name, 
			HttpServletRequest request, boolean isHtml, int status) throws Exception;
}
