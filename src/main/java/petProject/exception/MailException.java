/*
========================================================================
파    일    명 : MailException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2020.11.20
작  성  내  용 : 메일 익셉션 정의
========================================================================
*/
package petProject.exception;


public class MailException extends MessageException {
	private static final long	 serialVersionUID = 1L;
	private final String statusCode;
	public MailException(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public MailException(String statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public MailException(String statusCode, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public MailException(String statusCode, Throwable cause) {
		super(cause);
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}
}