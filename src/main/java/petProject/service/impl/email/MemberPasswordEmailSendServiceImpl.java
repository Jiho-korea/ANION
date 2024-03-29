/*
========================================================================
파    일    명 : MemberPasswordEmailSendServiceImpl.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : MemberIdProfile vo와 임시 비밀번호를 발급받아 mailsendservice를 이용하는 서비스
========================================================================
 */
package petProject.service.impl.email;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.service.email.MailSendService;
import petProject.service.email.MemberPasswordEmailSendService;
import petProject.vo.dto.Member;

@Service("memberPasswordEmailSendService")
@Transactional(rollbackFor = SQLException.class)
public class MemberPasswordEmailSendServiceImpl implements MemberPasswordEmailSendService {
//	@Value("${mail.smtp.url.local}")
	@Value("${mail.smtp.url.server}")
	private String url;

	@Resource(name = "mailSendService")
	MailSendService mailSendService;

	@Override
	public boolean sendPassword(Member member, String tempPassword, HttpServletRequest request, boolean isHtml)
			throws Exception {
		String mailHead = null;
		String mailContent = null;

		mailHead = "<h1>[ANION] 임시 비밀번호 발급</h1><br><p>임시 비밀번호가 발급되었습니다. 로그인후 변경해주세요!</p><br>";
		mailContent = tempPassword + "<br><a href='" + url + request.getContextPath() + "/login"
				+ "'target='_blank'>[ANION]</a>";

		mailSendService.sendMail(member.getMemberId(), member.getMemberName(), mailHead, mailContent, request, isHtml);
		return true;
	}

}