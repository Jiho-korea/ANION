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

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import interceptor.AdminCheckInterceptor;
import interceptor.EmailValidCheckInterceptor;
import interceptor.ImageAuthCheckInterceptor;
import interceptor.InfoAuthCheckInterceptor;
import interceptor.LoginCheckInterceptor;
import interceptor.LogoutCheckInterceptor;
import interceptor.PopupPetKindCookieCheckInterceptor;
import interceptor.PopupPetKindCookieDeleteInterceptor;
import interceptor.PopupPetLocationCookieCheckInterceptor;
import interceptor.PopupPetLocationCookieDeleteInterceptor;
import interceptor.MemberWithdrawalCheckInterceptor;

@Configuration
@EnableWebMvc
@EnableScheduling
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
	public PopupPetKindCookieCheckInterceptor popupPetKindCookieCheckInterceptor() {
		return new PopupPetKindCookieCheckInterceptor();
	}

	@Bean
	public PopupPetKindCookieDeleteInterceptor popupPetKindCookieDeleteInterceptor() {
		return new PopupPetKindCookieDeleteInterceptor();
	}

	@Bean
	public PopupPetLocationCookieCheckInterceptor popupPetLocationCookieCheckInterceptor() {
		return new PopupPetLocationCookieCheckInterceptor();
	}

	@Bean
	public PopupPetLocationCookieDeleteInterceptor popupPetLocationCookieDeleteInterceptor() {
		return new PopupPetLocationCookieDeleteInterceptor();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("classpath:/message");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(10); // reload messages every 10 seconds
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor MessageSourceAccessor() {
		return new MessageSourceAccessor(messageSource());
	}

	@Bean
	public LogoutCheckInterceptor logoutCheckInterceptor() {
		return new LogoutCheckInterceptor();
	}

	@Bean
	public EmailValidCheckInterceptor emailValidCheckInterceptor() {
		return new EmailValidCheckInterceptor();
	}

	@Bean
	public MemberWithdrawalCheckInterceptor memberWithdrawalCheckInterceptor() {
		return new MemberWithdrawalCheckInterceptor();
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
		registry.addViewController("/home").setViewName("home/main");
		registry.addViewController("/about").setViewName("company/about");
		registry.addViewController("/vision").setViewName("company/vision");
		registry.addViewController("/preservation").setViewName("company/preservation");
		registry.addViewController("/directions").setViewName("company/directions");
		registry.addViewController("/petFood").setViewName("company/petFood");
		registry.addViewController("/profile").setViewName("member/profile/memberProfile");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor()).addPathPatterns("/pet/**", "/register/**", "/list/**",
				"/admin/**", "/info/**", "/edit/**", "/profile/**", "/posting/**", "/popup/petKind/**", "/guidance/**",
				"/memberWithdrawal/**");
		registry.addInterceptor(emailValidCheckInterceptor()).excludePathPatterns("/home", "/about", "/vision",
				"/preservation", "/directions", "/petFood", "/profile", "/popup/**", "/login", "/signup/**", "/logout",
				"/email/sent", "/memberWithdrawal/**", "/member/find/**");
		registry.addInterceptor(memberWithdrawalCheckInterceptor()).excludePathPatterns("/home", "/about", "/vision",
				"/preservation", "/directions", "/petFood", "/profile", "/popup/**", "/login", "/signup/**", "/logout",
				"/email/sent", "/memberWithdrawal/**", "/member/find/**");
		registry.addInterceptor(logoutCheckInterceptor()).addPathPatterns("/member/find/**", "/login", "/signup/step1");
		registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(adminCheckInterceptor()).addPathPatterns("/admin/**");
		registry.addInterceptor(infoAuthCheckInterceptor()).addPathPatterns("/info/**");
		registry.addInterceptor(imageAuthCheckInterceptor()).addPathPatterns("/posting/img/**");
		registry.addInterceptor(popupPetKindCookieCheckInterceptor()).addPathPatterns("/popup/petKind/**");
		registry.addInterceptor(popupPetKindCookieDeleteInterceptor()).excludePathPatterns("/register/step1",
				"/popup/petKind/**");
		registry.addInterceptor(popupPetLocationCookieCheckInterceptor()).addPathPatterns("/pet/location/**");
		registry.addInterceptor(popupPetLocationCookieDeleteInterceptor()).excludePathPatterns("/pet/list",
				"/pet/location/**");
	}

}
