/*
========================================================================
파    일    명 : MailSendServiceImpl.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.06.23
작  성  내  용 : 이메일 발송 서비스 구현 클래스
========================================================================
*/
package petProject.service.impl.email;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import petProject.exception.MailException;
import petProject.service.email.MailSendService;
import petProject.vo.MailStatus;;

@Service("mailSendService")
@Transactional(rollbackFor = SQLException.class)
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private Session mailSession;

	@Value("${mail.smtp.from_addr}")
	private String from_addr;
	@Value("${mail.smtp.from_name}")
	private String from_name;

	@Override
	public boolean sendMail(String to_addr, String to_name, String mailHead, String mailContent,
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

			message.setSubject("[" + from_name + "]");//

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
