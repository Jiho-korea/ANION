/*
========================================================================
파    일    명 : ImageUploadException.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : ImageUpload 예외 발생 처리 클래스
========================================================================
*/
package petProject.exception;

public class ImageUploadException extends RuntimeException {
	public ImageUploadException(String message) {
		super(message);
	}
}
