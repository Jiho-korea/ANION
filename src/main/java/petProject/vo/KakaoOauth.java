package petProject.vo;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import petProject.service.SocialOauth;

@RequiredArgsConstructor
@Component
public class KakaoOauth implements SocialOauth {
	@Override
	public String getOauthRedirectURL() {
		return "";
	}

	@Override
	public String requestAccessToken(String code) {
		return null;
	}
}