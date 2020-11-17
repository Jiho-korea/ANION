/*
========================================================================
파    일    명 : MailSendServiceImpl.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 메일 인증 링크 보내는 클래스
========================================================================
*/
package petProject.service.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import petProject.service.MailSendService;

@Service("mailSendService")
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	public void sendAuthMail(String memberId, HttpServletRequest request) throws Exception {	
		// 인증메일 보내기
		MimeMessage mail = mailSender.createMimeMessage();
		String mailContent = "<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
                + "<a href='http://localhost:8080" + request.getContextPath() + "/valid?memberId=" 
                + memberId + "'target='_blank'>이메일 인증 확인</a>";
		try {
		    mail.setSubject("회원가입 이메일 인증 ", "utf-8");
		    mail.setText(mailContent, "utf-8", "html");
		    mail.addRecipient(Message.RecipientType.TO, new InternetAddress(memberId));
		    
		    mailSender.send(mail);
		} catch (MessagingException e) {
		    e.printStackTrace();
		}

	}
}
