/*
========================================================================
파    일    명 : ChangeProfileEmailServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 비밀번호 변경 확인 이메일 서비스 인터페이스 구현 클래스
========================================================================
*/
package petProject.service.impl.email;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import petProject.service.email.ChangeProfileEmailService;
import petProject.service.email.MailSendService;
import petProject.vo.dto.Emailcode;

@Service("changeProfileEmailService")
public class ChangeProfileEmailServiceImpl implements ChangeProfileEmailService {
	@Value("${mail.smtp.url.local}")
//	@Value("${mail.smtp.url.server}")
	private String url;

	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	@Override
	public boolean createChangeProfileEmail(Emailcode emailcode, String to_addr, String to_name,
			HttpServletRequest request, boolean isHtml) throws Exception {
		String mailHead = null;
		String mailContent = null;

		mailHead = "<h1>[ANION] 이메일 변경 인증</h1><br><p>인증번호 6자리를 입력하시면 이메일 변경이 완료됩니다.</p>";
		mailContent = emailcode.getEmailCode() + "<br><a href='" + url + request.getContextPath()
				+ "/email/validForm?memberId=" + emailcode.getMemberId() + "'target='_blank'>[ANION]</a>";

		mailSendService.sendMail(to_addr, to_name, mailHead, mailContent, request, isHtml);
		return true;
	}

}
