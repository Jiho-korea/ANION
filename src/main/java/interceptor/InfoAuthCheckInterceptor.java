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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.exception.PetNotFoundException;
import petProject.service.PetInfoService;
import petProject.vo.AuthInfo;
import petProject.vo.Pet;
import petProject.vo.ScriptWriter;

public class InfoAuthCheckInterceptor implements HandlerInterceptor {

	@Resource(name = "petInfoService")
	PetInfoService petInfoService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (request.getParameter("petRegistrationNumber") != null) {
			Pet pet = null;
			try {
				pet = petInfoService.selectPet(Integer.parseInt(request.getParameter("petRegistrationNumber")));
			} catch (PetNotFoundException e) {
				e.printStackTrace();
				return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			} catch (NumberFormatException e) {
				return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			}
			if (!"0".equals(authInfo.getMemberlevel().getMemberLevelCode())
					&& authInfo.getMemberNumber() != pet.getMember().getMemberNumber()) {
				return ScriptWriter.write("권한이 없습니다", "home", request, response);
			}
			if ("0".equals(authInfo.getMemberlevel().getMemberLevelCode())
					&& authInfo.getMemberNumber() != pet.getMember().getMemberNumber()) {
				request.setAttribute("admin", true);
			}
			return true;
		} else {
			return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
		}

	}

}
