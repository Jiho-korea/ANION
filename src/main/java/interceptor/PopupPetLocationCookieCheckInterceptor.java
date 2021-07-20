package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;

public class PopupPetLocationCookieCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String name = null;
		Cookie[] cookieList = request.getCookies();

		try {
			for (int i = 0; i < cookieList.length; i++) {
				if (cookieList[i].getName().equals("petLocation")) {
					name = cookieList[i].getName();
				}
			}
			if (name.equals("petLocation")) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return ScriptWriter.write("잘못된 접근입니다", "home", request, response);
		}
	}

}
