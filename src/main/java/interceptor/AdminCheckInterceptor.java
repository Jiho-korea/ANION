/*
========================================================================
파    일    명 : AdminCheckInterceptor.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 관리자인지 검사하는 인터셉터
========================================================================
*/
package interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.vo.AuthInfo;
import petProject.vo.Memberlevel;

public class AdminCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		Memberlevel memberLevel = authInfo.getMemberlevel();
		if (!"0".equals(memberLevel.getMemberLevelCode())) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("location.href='" + request.getContextPath() + "/home';");
			out.println("</script>");
			out.flush();
			return false;
		}

		return true;
	}

}
