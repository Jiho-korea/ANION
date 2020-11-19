/*
========================================================================
파    일    명 : MailSmtpAuthConfig.java
========================================================================
작    성    자 : 송찬영, 임원석, 강지호
작    성    일 : 2020.11.20
작  성  내  용 : 메일 작성 config 파일
========================================================================
*/
package config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/mail/config/mail.properties")
public class MailSmtpAuthConfig {
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.auth}")
	private String auth;
	@Value("${mail.smtp.port}")
	private String port;
	@Value("${mail.smtp.userid}")
	private String username;
	@Value("${mail.smtp.userpw}")
	private String password;
	@Value("${session.setDebug}")
	private String session_debug;
	@Value("${mail.smtp.debug}")
	private String mail_debug;
	
	@Bean
	public Session mailSession() {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.userid", username);
		props.put("mail.smtp.userpw", password);
		props.put("session.setDebug", session_debug);
		// TODO: 개발 완료후 삭제
		props.put("mail.smtp.debug", mail_debug);

		switch (Integer.parseInt(port)) {
		case 465:
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "465");
			break;
		case 587:
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			break;
		default:
			props.put("mail.smtp.port", "25");
			break;
		}
		// Session session = Session.getDefaultInstance(props, null);
		// TODO: SMTP서버 접속 인증
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(Boolean.parseBoolean(session_debug));  // Boolean.parseBoolean()

		return session;
	}
}
