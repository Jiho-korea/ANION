
/*
========================================================================
파    일    명 : ImageUploadException.java
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.03.21
작  성  내  용 : ImageDelete 예외 발생 처리 클래스
========================================================================
*/
package petProject.exception;

public class ImageNotExistException extends RuntimeException {
	public ImageNotExistException(String message) {
		super(message);
	}
}