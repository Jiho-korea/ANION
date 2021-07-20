/*
========================================================================
파    일    명 : PopupCookieDeleteInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.15
작  성  내  용 : 등록페이지, 팝업창 외에는 쿠키 제거
========================================================================
*/
package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class PopupPetKindCookieDeleteInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Cookie petKind = new Cookie("petKind", "true");
		petKind.setPath(request.getContextPath() + "/popup/petKind");
		petKind.setMaxAge(0);
		response.addCookie(petKind);

		return true;
	}

}
