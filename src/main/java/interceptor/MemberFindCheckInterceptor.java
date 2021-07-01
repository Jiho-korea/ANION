package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.service.ScriptWriter;
import petProject.vo.AuthInfo;

public class MemberFindCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
			if (authInfo != null) {
				return ScriptWriter.write("로그인 상태입니다.", "home", request, response);
			}
		}

		return true;
	}

}
