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
수    정    자 : 송찬영
수    정    일 : 2021.05.15
수  정  내  용 : 품종 선택 팝업창 Interceptor 동작
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import interceptor.AdminCheckInterceptor;
import interceptor.EmailcodeCheckInterceptor;
import interceptor.ImageAuthCheckInterceptor;
import interceptor.InfoAuthCheckInterceptor;
import interceptor.LoginCheckInterceptor;
import interceptor.PopupCookieCheckInterceptor;
import interceptor.PopupCookieDeleteInterceptor;

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

	@Bean
	public ImageAuthCheckInterceptor imageAuthCheckInterceptor() {
		return new ImageAuthCheckInterceptor();
	}

	@Bean
	public EmailcodeCheckInterceptor emailcodeCheckInterceptor() {
		return new EmailcodeCheckInterceptor();
	}
	
	@Bean
	public PopupCookieCheckInterceptor popupCookieCheckInterceptor() {
		return new PopupCookieCheckInterceptor();
	}
	
	@Bean
	public PopupCookieDeleteInterceptor popupCookieDeleteInterceptor() {
		return new PopupCookieDeleteInterceptor();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
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
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor()).addPathPatterns("/pet/**", "/register/**", "/list/**",
				"/admin/**", "/info/**", "/edit/**", "/profile/**", "/posting/**", "/popup/petKind/**");
		registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(adminCheckInterceptor()).addPathPatterns("/admin/**");
		registry.addInterceptor(infoAuthCheckInterceptor()).addPathPatterns("/info/**");
		registry.addInterceptor(imageAuthCheckInterceptor()).addPathPatterns("/posting/img/**");
		registry.addInterceptor(emailcodeCheckInterceptor()).addPathPatterns("/email/**");
		registry.addInterceptor(popupCookieCheckInterceptor()).addPathPatterns("/popup/petKind/**");
		registry.addInterceptor(popupCookieDeleteInterceptor()).excludePathPatterns("/register/step1", "/popup/petKind/**");
	}

}
