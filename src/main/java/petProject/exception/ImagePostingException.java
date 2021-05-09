/*
========================================================================
파    일    명 : ImagePostingException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 반려견 사진 자랑 게시판에 게시물 등록시 발생하는 예외 처리 클래스
========================================================================
*/
package petProject.exception;

public class ImagePostingException extends RuntimeException {
	public ImagePostingException(String message) {
		super(message);
	}
}
