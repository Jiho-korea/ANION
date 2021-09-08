package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import petProject.vo.SocialLoginType;

@Configuration
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {

	@Override
	public SocialLoginType convert(String s) {
		return SocialLoginType.valueOf(s.toUpperCase());
	}
}
