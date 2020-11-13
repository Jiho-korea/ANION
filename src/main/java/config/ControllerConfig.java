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

import controller.ImageListController;
import controller.LoginController;
import controller.LogoutController;
import controller.MainController;
import controller.OwnerRegisterController;
import controller.PetInfoController;
import controller.PetRegisterController;
import controller.admin.OwnerListController;

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
	public OwnerRegisterController ownerRegisterController() {
		return new OwnerRegisterController();
	}

	@Bean
	public OwnerListController ownerListController() {
		return new OwnerListController();
	}
}
