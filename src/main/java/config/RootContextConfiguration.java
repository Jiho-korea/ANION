package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 루트 컨텍스트 설정파일
 */
@Configuration
@Import({ ContextDataSource.class, ContextSqlMapper.class, ImageUploadConfig.class })
@ComponentScan(basePackages = { "petProject.service.impl" })
public class RootContextConfiguration {
}
