package petProject.service.email;

import javax.servlet.http.HttpServletRequest;

public interface ChangeProfileEmailService {
	public boolean createChangeProfileEmail(String to_addr, String to_name, HttpServletRequest request, boolean isHtml,
			String emailcode) throws Exception;
}
