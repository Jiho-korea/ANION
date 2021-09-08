package petProject.service;

import petProject.vo.FacebookOauth;
import petProject.vo.GoogleOauth;
import petProject.vo.KakaoOauth;
import petProject.vo.NaverOauth;
import petProject.vo.SocialLoginType;

public interface SocialOauth {
	
    String getOauthRedirectURL();

    String requestAccessToken(String code);

    default SocialLoginType type() {
        if (this instanceof FacebookOauth) {
            return SocialLoginType.FACEBOOK;
        } else if (this instanceof GoogleOauth) {
            return SocialLoginType.GOOGLE;
        } else if (this instanceof NaverOauth) {
            return SocialLoginType.NAVER;
        } else if (this instanceof KakaoOauth) {
            return SocialLoginType.KAKAO;
        } else {
            return null;
        }
    }
    
}
