/*
========================================================================
파    일    명 : MemberWithdrawalCheckInterceptor.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.30
작  성  내  용 : 탈퇴신청을 한 사용자가 이용할 수 있는 페이지 제한 인터셉터
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

public class MemberWithdrawalCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

			Memberauth memberauth = authInfo.getMemberauth();
			if (memberauth.getMemberAuthStatus() == 3) {
				return ScriptWriter.write(messageSourceAccessor.getMessage("memberId.memberWithdrawal"), "memberWithdrawal", request, response);
			}
		} catch (NullPointerException e) {
			return ScriptWriter.write(messageSourceAccessor.getMessage("memberId"), "home", request, response);
		}
		return true;
	}

}
