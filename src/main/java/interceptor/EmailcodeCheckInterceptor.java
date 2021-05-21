/*
========================================================================
파    일    명 : EmailCodeCheckInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.03.20
작  성  내  용 : tempAuth 세션을 검증하는 interceptor
========================================================================
*/
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;

public class EmailcodeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		try {
			if (session != null) {
				boolean tempAuth = (Boolean) session.getAttribute("tempAuth");
			}
		} catch (NullPointerException e) {
			return ScriptWriter.write("잘못된 접근입니다", "home", request, response);
		}

		return true;

	}

}
