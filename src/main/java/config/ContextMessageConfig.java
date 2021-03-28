/*
========================================================================
파    일    명 : ContextMessageConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.03.28
작  성  내  용 : 다국어 설정을 위한 MVC 설정
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ContextMessageConfig {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/label");
		source.addBasenames("classpath:/message/error");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(60);
		source.setUseCodeAsDefaultMessage(true);

		return source;
	}

	@Bean
	public SessionLocaleResolver localResolver() {
		return new SessionLocaleResolver();
	}

}
