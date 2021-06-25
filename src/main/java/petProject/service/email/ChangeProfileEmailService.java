/*
========================================================================
파    일    명 : ChangeProfileEmailService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 비밀번호 변경 확인 이메일 서비스 인터페이스 
========================================================================
*/
package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

public interface ChangeProfileEmailService {
	public boolean createChangeProfileEmail(String to_addr, String to_name, HttpServletRequest request, boolean isHtml,
			String emailcode) throws Exception;
}
