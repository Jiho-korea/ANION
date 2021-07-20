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
