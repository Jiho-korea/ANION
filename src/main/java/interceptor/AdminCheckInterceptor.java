/*
========================================================================
파    일    명 : LoginCheckInterceptor.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 세션 검사하는 클래스
========================================================================
*/
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.vo.AuthInfo;

public class AdminCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		int memberLevel = authInfo.getMemberLevel();
		if (memberLevel != 0) {
			// String refererPage = request.getServletPath();
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		// response.sendRedirect(request.getContextPath() + "/login/login");

		// }
		return true;
	}

}
