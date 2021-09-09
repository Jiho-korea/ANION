package petProject.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import petProject.service.SocialOauth;
import petProject.vo.SocialLoginType;

@Service
@RequiredArgsConstructor
public class OauthService {

	private final List<SocialOauth> socialOauthList;
	private final HttpServletResponse response;

	public void request(SocialLoginType socialLoginType) {
		SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
		String redirectURL = socialOauth.getOauthRedirectURL();
		try {
			response.sendRedirect(redirectURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String requestAccessToken(SocialLoginType socialLoginType, String code) {
		SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
		return socialOauth.requestAccessToken(code);
	}

	private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
		return socialOauthList.stream().filter(x -> x.type() == socialLoginType).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
	}

}
