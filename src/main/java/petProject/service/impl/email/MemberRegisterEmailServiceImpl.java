package petProject.service.impl.email;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import petProject.service.email.MailSendService;
import petProject.service.email.MemberRegisterEmailService;
import petProject.vo.dto.Member;

@Service("memberRegisterEmailService")
public class MemberRegisterEmailServiceImpl implements MemberRegisterEmailService {
	@Value("${mail.smtp.url.local}")
	private String url;

	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	@Override
	public boolean createMemberRegisterEmail(Member member, HttpServletRequest request, boolean isHtml,
			String emailcode) throws Exception {
		String mailHead = null;
		String mailContent = null;

		mailHead = "<h1>[ANION] 회원가입 인증메일</h1><br><p>로그인 후 인증번호 6자리를 입력하시면 이메일 인증이 완료됩니다.</p><br>";
		mailContent = emailcode + "<br><a href='" + url + request.getContextPath() + "/login"
				+ "'target='_blank'>[ANION]</a>";

		mailSendService.sendMail(member.getMemberId(), member.getMemberName(), mailHead, mailContent, request, isHtml);
		return true;
	}
}
