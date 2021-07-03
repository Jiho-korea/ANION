package petProject.service.impl.email;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.service.email.MailSendService;
import petProject.service.email.MemberPasswordEmailSendService;
import petProject.vo.dto.MemberIdProfile;

@Service("memberPasswordEmailSendService")
@Transactional
public class MemberPasswordEmailSendServiceImpl implements MemberPasswordEmailSendService {
	@Value("${mail.smtp.url.server}")
	private String url;

	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	@Override
	public boolean sendPassword(MemberIdProfile memberIdProfile, String tempPassword, HttpServletRequest request,
			boolean isHtml) throws Exception {
		String mailHead = null;
		String mailContent = null;

		mailHead = "<h1>[ANION] 임시 비밀번호 발급</h1><br><p>임시 비밀번호가 발급되었습니다. 로그인후 변경해주세요!</p><br>";
		mailContent = tempPassword + "<br><a href='" + url + request.getContextPath() + "/login"
				+ "'target='_blank'>[ANION]</a>";

		mailSendService.sendMail(memberIdProfile.getMemberId(), memberIdProfile.getMemberName(), mailHead, mailContent,
				request, isHtml);
		return true;
	}

}
