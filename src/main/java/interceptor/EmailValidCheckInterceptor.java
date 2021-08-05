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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Memberauth;

public class EmailValidCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

			Memberauth memberauth = authInfo.getMemberauth();
			if (memberauth.getMemberAuthStatus() == 0) {
				return ScriptWriter.write(messageSourceAccessor.getMessage("memberId.valid"), "home", request, response);
			}
		} catch (NullPointerException e) {
			return ScriptWriter.write(messageSourceAccessor.getMessage("memberId"), "home", request, response);
		}
		return true;
	}

}
