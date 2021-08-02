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

import controller.admin.code.kind.KindcodeDeleteController;
import controller.admin.code.kind.KindcodeInsertController;
import controller.admin.code.kind.KindcodeListController;
import controller.admin.code.kind.KindcodeUpdateController;
import controller.admin.event.EventListController;
import controller.admin.event.noseprint.image.NoseprintImageDownloadController;
import controller.admin.event.noseprint.image.NoseprintImageListAdminController;
import controller.admin.event.noseprint.pet.NoseprintPetListAdminController;
import controller.admin.image.ImageDownloadController;
import controller.admin.image.ImageListAdminController;
import controller.admin.member.MemberListController;
import controller.admin.pet.PetListAdminController;
import controller.event.noseprint.image.NoseprintImageDeleteController;
import controller.event.noseprint.image.NoseprintImageEventGuidanceController;
import controller.event.noseprint.image.NoseprintImageListController;
import controller.event.noseprint.pet.NoseprintPetListController;
import controller.event.popup.EventPopupController;
import controller.exceptionHandler.GlobalExceptionController;
import controller.image.ImageDeleteController;
import controller.image.ImageListController;
import controller.member.EmailValidController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.MemberFindController;
import controller.member.MemberRegisterController;
import controller.member.ProfileEditController;
import controller.member.MemberWithdrawalController;
import controller.pet.PetInfoController;
import controller.pet.PetKindPopupController;
import controller.pet.PetListController;
import controller.pet.PetLocationController;
import controller.pet.PetRegisterController;

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
	public ImageListAdminController imageListAdminController() {
		return new ImageListAdminController();
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

	// 반려견 자랑 관련 컨트롤러 임시 삭제
	// 반려견 자랑 게시글 쓰기 컨트롤러
//	@Bean
//	public ImagePostingController imagePostingController() {
//		return new ImagePostingController();
//	}

	// 반려견 자랑 게시판 컨트롤러
//	@Bean
//	public ImageBoardController imageBoardController() {
//		return new ImageBoardController();
//	}

	// 반려견 자랑 게시물 보기 컨트롤러
//	@Bean
//	public ViewImagePostController viewImagePostController() {
//		return new ViewImagePostController();
//	}

	@Bean
	public EventPopupController eventPopupController() {
		return new EventPopupController();
	}

	@Bean
	public PetKindPopupController petKindPopupController() {
		return new PetKindPopupController();
	}

	// 비문 등록 이벤트 관련
	@Bean
	public NoseprintImageEventGuidanceController noseprintImageEventGuidanceController() {
		return new NoseprintImageEventGuidanceController();
	}

	@Bean
	public NoseprintPetListController noseprintPetListController() {
		return new NoseprintPetListController();
	}

	@Bean
	public NoseprintImageListController noseprintImageListController() {
		return new NoseprintImageListController();
	}

	@Bean
	public NoseprintImageListAdminController noseprintImageListAdminController() {
		return new NoseprintImageListAdminController();
	}

	@Bean
	public NoseprintImageDeleteController noseprintImageDeleteController() {
		return new NoseprintImageDeleteController();
	}

	@Bean
	public NoseprintImageDownloadController noseprintImageDownloadController() {
		return new NoseprintImageDownloadController();
	}

	@Bean
	public NoseprintPetListAdminController noseprintPetListAdminController() {
		return new NoseprintPetListAdminController();
	}
	// 여기 까지

	@Bean
	public EventListController eventListController() {
		return new EventListController();
	}

	@Bean
	public MemberFindController memberFindController() {
		return new MemberFindController();
	}
	
	@Bean
	public GlobalExceptionController globalExceptionController() {
		return new GlobalExceptionController();
	}

	@Bean
	public PetLocationController petLocationController() {
		return new PetLocationController();

	}
	
	@Bean
	public MemberWithdrawalController memberWithdrawalController() {
		return new MemberWithdrawalController();
	}
}
