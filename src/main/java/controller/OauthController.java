package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import petProject.service.impl.OauthService;
import petProject.vo.SocialLoginType;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class OauthController {

	private OauthService oauthService;

	/**
	 * 사용자로부터 SNS 로그인 요청을 Social Login Type 을 받아 처리
	 * 
	 * @param socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
	 */
	@GetMapping(value = "/{socialLoginType}")
	public void socialLoginType(@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType) {
		System.out.println((">> 사용자로부터 SNS 로그인 요청을 받음 :: {} Social Login" + socialLoginType));
		oauthService.request(socialLoginType);
	}

	/**
	 * Social Login API Server 요청에 의한 callback 을 처리
	 * 
	 * @param socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
	 * @param code            API Server 로부터 넘어노는 code
	 * @return SNS Login 요청 결과로 받은 Json 형태의 String 문자열 (access_token, refresh_token
	 *         등)
	 */
	@GetMapping(value = "/{socialLoginType}/callback")
	public String callback(@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
			@RequestParam(name = "code") String code) {
		System.out.println((">> 소셜 로그인 API 서버로부터 받은 code :: {}" + code));
		return oauthService.requestAccessToken(socialLoginType, code);
	}

}
