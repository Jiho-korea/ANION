/*
========================================================================
파    일    명 : PopupPetLocationCookieDeleteInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.20
작  성  내  용 : list에서 등록 외에는 팝업창 쿠키 제거
========================================================================
*/
package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class PopupPetLocationCookieDeleteInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Cookie petLocation = new Cookie("petLocation", "true");
		petLocation.setPath(request.getContextPath() + "/pet/location");
		petLocation.setMaxAge(0);
		response.addCookie(petLocation);

		return true;
	}

}
