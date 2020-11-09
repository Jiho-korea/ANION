/*
========================================================================
파    일    명 : ImageUploadConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 파일 업로드 설정파일
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 루트 컨텍스트 설정파일
 */
@Configuration
public class ImageUploadConfig {
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760 * 10);
		return multipartResolver;
	}

}
