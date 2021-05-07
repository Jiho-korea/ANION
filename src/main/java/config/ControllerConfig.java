/*
========================================================================
파    일    명 : ControllerConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Controller 빈 등록
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.05
수  정  내  용 : MainController -> PetListController 로 이름 변경
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.EmailValidController;
import controller.EventPopupController;
import controller.ImageDeleteController;
import controller.ImageListController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberRegisterController;
import controller.PetInfoController;
import controller.PetKindPopupController;
import controller.PetListController;
import controller.PetRegisterController;
import controller.ProfileEditController;
import controller.admin.ImageDownloadController;
import controller.admin.KindcodeDeleteController;
import controller.admin.KindcodeInsertController;
import controller.admin.KindcodeListController;
import controller.admin.KindcodeUpdateController;
import controller.admin.MemberListController;
import controller.admin.PetListAdminController;
import controller.bbs.image.ImageBoardController;
import controller.bbs.image.ImagePostingController;

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
	public ImageListController imageListController() {
		return new ImageListController();
	}

	@Bean
	public ImageDeleteController imageDeleteController() {
		return new ImageDeleteController();
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
	public EmailValidController emailValidController() {
		return new EmailValidController();
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
	public PetListAdminController petListAdminController() {
		return new PetListAdminController();
	}

	@Bean
	public ProfileEditController editController() {
		return new ProfileEditController();
	}

	@Bean
	public PetListController petListController() {
		return new PetListController();
	}

	@Bean
	public ImageDownloadController imageDownloadController() {
		return new ImageDownloadController();
	}

	@Bean
	public ImagePostingController imagePostingController() {
		return new ImagePostingController();
	}

	@Bean
	public ImageBoardController imageBoardController() {
		return new ImageBoardController();
	}

	@Bean
	public EventPopupController eventPopupController() {
		return new EventPopupController();
	}

	@Bean
	public PetKindPopupController petKindPopupController() {
		return new PetKindPopupController();
	}
}
