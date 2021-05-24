/*
========================================================================
파    일    명 : PetDeleteException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.23
작  성  내  용 : Pet Delete Exception class
========================================================================
*/
package petProject.exception;

public class PetDeleteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetDeleteException(String message) {
		super(message);
	}
}
