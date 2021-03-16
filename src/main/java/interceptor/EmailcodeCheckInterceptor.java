package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.vo.ScriptWriter;

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
