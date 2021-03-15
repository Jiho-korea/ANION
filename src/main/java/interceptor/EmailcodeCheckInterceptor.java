package interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

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
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("location.href='" + request.getContextPath() + "/home';");
			out.println("</script>");
			out.flush();

			return false;
		}
		
		return true;

	}

}
