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
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		
		Memberauth memberauth = authInfo.getMemberauth();
		if (memberauth.getMemberAuthStatus() == 0) {
			return ScriptWriter.write("이메일 인증을 완료하세요!", "home", request, response);
		}

		return true;
	}

}
