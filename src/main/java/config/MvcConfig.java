/*
========================================================================
파    일    명 : MvcConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 스프링 MVC 설정
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.18
수  정  내  용 : 관리자 페이지, 반려견 세부정보 페이지에도 Interceptor가 동작하도록 설정
========================================================================
*/
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

import interceptor.AdminCheckInterceptor;
import interceptor.InfoAuthCheckInterceptor;
import interceptor.LoginCheckInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Bean
	public LoginCheckInterceptor loginCheckInterceptor() {
		return new LoginCheckInterceptor();
	}

	@Bean
	public AdminCheckInterceptor adminCheckInterceptor() {
		return new AdminCheckInterceptor();
	}

	@Bean
	public InfoAuthCheckInterceptor infoAuthCheckInterceptor() {
		return new InfoAuthCheckInterceptor();
	}

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
		registry.addViewController("/about").setViewName("company/about");
		registry.addViewController("/vision").setViewName("company/vision");
		registry.addViewController("/preservation").setViewName("company/preservation");
		registry.addViewController("/directions").setViewName("company/directions");
		registry.addViewController("/petFood").setViewName("company/petFood");
		registry.addViewController("/profile").setViewName("info/profile");
	}//

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor()).addPathPatterns("/main/**", "/register/**", "/list/**",
				"/admin/**", "/info/**", "/edit/**", "/profile/**", "/email/**");

		registry.addInterceptor(adminCheckInterceptor()).addPathPatterns("/admin/**");
		registry.addInterceptor(infoAuthCheckInterceptor()).addPathPatterns("/info/**");
	}

}
