/*
========================================================================
파    일    명 : MemberRegisterEmailServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 회원가입 확인 이메일 서비스 인터페이스 구현 클래스
========================================================================
*/
package petProject.service.impl.email;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import petProject.service.email.MailSendService;
import petProject.service.email.MemberRegisterEmailService;
import petProject.vo.dto.Emailcode;
import petProject.vo.dto.Member;

@Service("memberRegisterEmailService")
public class MemberRegisterEmailServiceImpl implements MemberRegisterEmailService {
	@Value("${mail.smtp.url.local}")
//	@Value("${mail.smtp.url.server}")
	private String url;

	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	@Override
	public boolean createMemberRegisterEmail(Emailcode emailcode, Member member, HttpServletRequest request,
			boolean isHtml) throws Exception {
		String mailHead = null;
		String mailContent = null;

		mailHead = "<h1>[ANION] 회원가입 인증메일</h1><br><p>안녕하세요, " + member.getMemberName() + "님</p>";
		mailContent = "<p>아래 버튼을 클릭하시면 이메일 인증이 완료됩니다!</p><br><a href='" + url + request.getContextPath()
				+ "/login?memberId=" + emailcode.getMemberId() + "&emailcode=" + emailcode.getEmailCode() + "'target='_blank'>[ANION]</a>";

		mailSendService.sendMail(member.getMemberId(), member.getMemberName(), mailHead, mailContent, request, isHtml);
		return true;
	}
}
