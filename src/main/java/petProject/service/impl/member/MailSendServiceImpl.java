/*
========================================================================
파    일    명 : MailSendServiceImpl.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.17
작  성  내  용 : 메일 인증 링크 보내는 클래스
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.21
작  성  내  용 : 서버에 올릴 때 사용될 mailContent 추가 (서버에 올릴 때만 사용함)
========================================================================
*/
package petProject.service.impl.member;

import java.io.UnsupportedEncodingException;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petProject.exception.MailException;
import petProject.service.member.MailSendService;
import petProject.vo.MailStatus;
import petProject.vo.dto.Member;

@Service("mailSendService")
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private Session mailSession;

	@Override
	public boolean sendMail(String from_addr, String from_name, String to_addr, Member member,
			HttpServletRequest request, boolean isHtml, String emailcode) throws MailException {

		boolean result = false;

		try {
			// TODO: 보내는 사람 주소 또는 보내는 사람 이름 변경
			// Address senderAddress = new InternetAddress(account,
			// MimeUtility.encodeText(from_name, "UTF-8", "B"));
			// TODO: 받는 사람 주소 또는 받는 사람 이름 변경
			// Address receiveAddress = new InternetAddress(to_address, to_name);
			Message message = new MimeMessage(mailSession);
			// message.setFrom(senderAddress);
			message.setFrom(new InternetAddress(from_addr, from_name));
			// message.setRecipients(Message.RecipientType.TO,
			// InternetAddress.parse(to_address));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to_addr, member.getMemberName()));

			message.setSubject("[애니온]");//

			String mailHead = null;
			String mailContent = null;

			if (member.getMemberauth().getMemberAuthStatus() == 0) {
				mailHead = "<h1>[ANION] 회원가입 인증메일</h1><br><p>로그인 후 인증번호 6자리를 입력하시면 이메일 인증이 완료됩니다.</p><br>";

			} else {
				mailHead = "<h1>[ANION] 이메일 변경 인증</h1><br><p>프로필에서 인증버튼을 클릭 후 인증번호 6자리를 입력하시면 이메일 변경이 완료됩니다.</p><br>";
			}
//			서버
			mailContent = emailcode + "<br><a href='http://anionbio.com:8119" + request.getContextPath() + "/login"
					+ "'target='_blank'>[ANION]</a>";
//			로컬
//			mailContent = emailcode + "<br><a href='http://localhost:8080" + request.getContextPath() + "/login"
//					+ "'target='_blank'>[ANION]</a>";

			if (isHtml) {
				message.setContent(mailHead + mailContent, "text/html;charset=UTF-8");
			} else {
				message.setText(mailHead + mailContent);
			}

			Transport.send(message);
			result = true;
		} catch (AuthenticationFailedException authenticationFailedException) {
			result = false;
			authenticationFailedException.printStackTrace();
			throw new MailException(MailStatus.SEND_FAIL, "메일을 발송하는 중 에러가 발생했습니다.", authenticationFailedException);
		} catch (MessagingException messagingException) {
			result = false;
			throw new MailException(MailStatus.SEND_FAIL, "메일을 발송하는 중 에러가 발생했습니다.", messagingException);
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			result = false;
			throw new MailException(MailStatus.SEND_FAIL, "메일을 발송하는 중 에러가 발생했습니다.", unsupportedEncodingException);
		}
		return result;
	}

}
