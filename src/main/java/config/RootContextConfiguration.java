/*
========================================================================
파    일    명 : RootContextConfiguration.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : configuration 클래스를 통해 설정을 한곳에 등록
========================================================================
*/
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 루트 컨텍스트 설정파일
 */
@Configuration
@Import({ ContextDataSource.class, ContextSqlMapper.class, ImageUploadConfig.class, MailAuthConfiguration.class})
@ComponentScan(basePackages = { "petProject.service.impl" })
public class RootContextConfiguration {
	
}
