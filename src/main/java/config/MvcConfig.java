package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import interceptor.LoginCheckInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	// �씤�꽣�뀎�꽣

	// 濡쒓렇�씤 �씤�꽣�뀎�꽣
	@Bean
	public LoginCheckInterceptor loginCheckInterceptor() {
		return new LoginCheckInterceptor();
	}

	//
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.addBasenames("message.error");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/list").setViewName("list/petList");
		registry.addViewController("/home").setViewName("home/main");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor()).addPathPatterns("/main/**", "/register/**", "/list/**");

	}

}
