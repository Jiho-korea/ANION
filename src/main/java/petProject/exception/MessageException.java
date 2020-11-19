/**
 * Copyright (c) 2014  Upost , Inc. All Rights Reserved.
 * ProjectName	:
 * Description	:
 * 1. FileName	: MessageException.java
 * 2. Package	: vvsp.utils
 * 3. Commnet	:
 * 4. 작성자	: JunChulGun
 * 5. 작성일	: 2014. 2. 6. 오후 2:56:33
 * 6. 변경이력	:
 * 이름	|	일자	|	근거자료	|	변경내용
 * -----------------------------------------------------
 * JunChulGun	|	2014. 2. 6.	|			|	신규 개발.
 *
 * @author: JunChulGun
 * @version: 1.0
 * @since: 2014. 2. 6.
 */
package petProject.exception;

public class MessageException extends RuntimeException {
	private static final long	 serialVersionUID = 1L;

	public MessageException() {
		super();
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageException(Throwable cause) {
		super(cause);
	}
}