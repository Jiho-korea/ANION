/*
========================================================================
파    일    명 : PasswordSecurityConfig.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.20
작  성  내  용 : 이메일 암호화 빈 설정
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class PasswordSecurityConfig {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}