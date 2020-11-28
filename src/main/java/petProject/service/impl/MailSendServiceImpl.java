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
package petProject.service.impl;

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
import petProject.service.MailSendService;
import petProject.vo.MailStatus;

@Service("mailSendService")
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private Session mailSession;

	@Override
	public boolean sendMail(String from_addr, String from_name, String to_addr, String to_name,
			HttpServletRequest request, boolean isHtml) throws Exception {

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
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to_addr, to_name));

			message.setSubject("[애니온]");//

			// 서버에 올릴 떈 이거 주석 풀어야함
			String mailContent = "<h1>[ANION] 회원가입 인증메일</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
					+ "<a href='http://anionbio.com:8119" + request.getContextPath() + "/valid?memberId=" + to_addr
					+ "'target='_blank'>이메일 인증 확인</a>";

			// 로컬 호스트에서 실행시킬 떈 이거 사용
//			String mailContent = "<h1>[ANION] 회원가입 인증메일</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
//					+ "<a href='http://localhost:8080" + request.getContextPath() + "/valid?memberId=" + to_addr
//					+ "' target='_blank'>이메일 인증 확인</a>";

			if (isHtml) {
				message.setContent(mailContent, "text/html;charset=UTF-8");
			} else {
				message.setText(mailContent);
			}

			Transport.send(message);
			result = true;
		} catch (AuthenticationFailedException authenticationFailedException) {
			result = false;
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
