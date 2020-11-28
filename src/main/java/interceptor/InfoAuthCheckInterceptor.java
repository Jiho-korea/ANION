/*
========================================================================
파    일    명 : InfoAuthCheckInterceptor.java
========================================================================
작    성    자 : 임원석, 송찬영
작    성    일 : 2020.11.24
작  성  내  용 : 권한 체크 인터셉터
========================================================================
*/
package interceptor;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.PetInfoService;
import petProject.vo.AuthInfo;
import petProject.vo.Pet;

public class InfoAuthCheckInterceptor implements HandlerInterceptor {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (request.getParameter("petRegistrationNumber") != null) {
			Pet pet = petInfoService.selectPet(Integer.parseInt(request.getParameter("petRegistrationNumber")));

			if (authInfo.getMemberNumber() != pet.getMember().getMemberNumber()) {
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
		} else {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

	}

}