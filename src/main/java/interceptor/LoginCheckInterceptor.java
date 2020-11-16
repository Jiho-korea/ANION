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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.vo.Member;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Member member = (Member) session.getAttribute("login");
			if (member != null) {
				return true;
			}
		}

		// 컨텍스트 뒤의 경로를 request 객체에 넣어줌
		if (request.getServletPath() != null) {
			String refererPage = request.getServletPath();
			// System.out.println("LoginCheckInterceptor refererPage : " + refererPage);
			request.setAttribute("refererPage", refererPage);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login");
		dispatcher.forward(request, response);//
		// response.sendRedirect(request.getContextPath() + "/login/login");
		return false;
	}

}
