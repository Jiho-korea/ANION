/*
========================================================================
파    일    명 : MailAuthConfiguration.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : Mail을 보내기 위한 설정
========================================================================
*/
package config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailAuthConfiguration {
	
	@Bean(name="javaMailSender")
	public JavaMailSenderImpl getJavaMailSender() {
		
		Properties properties = new Properties(); 
		properties.put("mail.smtp.auth", true);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.starttls.required", true);
		properties.put("mail.debug", true);
		//
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("mail.vv1.co.kr");
		mailSender.setPort(25);
		mailSender.setUsername("mailuser");
		mailSender.setPassword("apdlf_13");
		mailSender.setDefaultEncoding("utf-8");
		mailSender.setJavaMailProperties(properties);
		
		return mailSender;
		
	}
	
}