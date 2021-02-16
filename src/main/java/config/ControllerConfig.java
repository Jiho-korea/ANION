/*
========================================================================
파    일    명 : ControllerConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Controller 빈 등록
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.EmailValidController;
import controller.EmailValidController2;
import controller.ImageListController;
import controller.LoginController;
import controller.LogoutController;
import controller.MainController;
import controller.MemberRegisterController;
import controller.PetInfoController;
import controller.PetRegisterController;
import controller.ProfileEditController;
import controller.admin.KindcodeDeleteController;
import controller.admin.KindcodeInsertController;
import controller.admin.KindcodeListController;
import controller.admin.KindcodeUpdateController;
import controller.admin.MemberListController;
import controller.admin.PetListController;

@Configuration
public class ControllerConfig {
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}

	@Bean
	public LogoutController logoutController() {
		LogoutController logoutController = new LogoutController();
		return logoutController;
	}

	@Bean
	public PetRegisterController petRegisterController() {
		PetRegisterController petRegisterController = new PetRegisterController();
		return petRegisterController;
	}

	@Bean
	public MainController mainController() {
		return new MainController();
	}

	@Bean
	public ImageListController imageListController() {
		return new ImageListController();
	}

	@Bean

	public PetInfoController petInfoController() {
		return new PetInfoController();
	}

	@Bean
	public MemberRegisterController memberRegisterController() {
		return new MemberRegisterController();
	}

	@Bean
	public MemberListController memberListController() {
		return new MemberListController();
	}

	@Bean
	public EmailValidController signupController() {
		return new EmailValidController();
	}

	@Bean
	public EmailValidController2 emailValidController2() {
		return new EmailValidController2();
	}
	
	@Bean
	public KindcodeListController kindcodeListController() {
		return new KindcodeListController();
	}

	@Bean
	public KindcodeInsertController kindcodeInsertController() {
		return new KindcodeInsertController();
	}

	@Bean
	public KindcodeUpdateController kindcodeUpdateController() {
		return new KindcodeUpdateController();
	}

	@Bean
	public KindcodeDeleteController kindcodeDeleteController() {
		return new KindcodeDeleteController();
	}

	@Bean
	public ProfileEditController editController() {
		return new ProfileEditController();
	}

	@Bean
	public PetListController petListController() {
		return new PetListController();
	}

}
