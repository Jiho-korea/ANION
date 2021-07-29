/*
========================================================================
파    일    명 : EmailValidCheckInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.27
작  성  내  용 : 이메일 인증 완료하지 않은 사용자는 로그인, 프로필만 가능
========================================================================
*/
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Memberauth;

public class EmailValidCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

			Memberauth memberauth = authInfo.getMemberauth();
			if (memberauth.getMemberAuthStatus() == 0) {
				return ScriptWriter.write("이메일 인증을 완료하세요!", "home", request, response);
			}
		} catch (NullPointerException e) {
			return ScriptWriter.write("로그인이 필요합니다", "home", request, response);
		}
		return true;
	}

}
