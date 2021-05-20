
/*
========================================================================
파    일    명 : ImgpostNotExistException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.08
작  성  내  용 : 삭제 되거나 존재하지 않는 게시글을 조회하려 할 떄 발생하는 예외
========================================================================
*/
package petProject.exception;

public class ImgpostNotExistException extends RuntimeException {
	public ImgpostNotExistException(String message) {
		super(message);
	}
}