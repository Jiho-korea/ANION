package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ImageListController;
import controller.LoginController;
import controller.LogoutController;
import controller.MainController;
import controller.PetInfoController;
import controller.PetRegisterController;

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
}
