/*
========================================================================
파    일    명 : MailStatus.java
========================================================================
작    성    자 : 송찬영, 임원석
작    성    일 : 2020.11.20
작  성  내  용 : 이메일 익셉션 문자열 추가
========================================================================
*/
package petProject.vo;

public class MailStatus {
	public static final String CREATED = "00";
	public static final String ACCEPTED = "10";
	public static final String SEND_READY = "20";
	public static final String SEND_OK = "90";
	public static final String UNUSED = "E0";
	public static final String TEMPLATE_INFO_NOT_FOUND = "E1";
	public static final String TEMPLATE_FILE_NOT_FOUND = "E2";
	public static final String TEMPLATE_ERROR = "E3";
	public static final String UNKOWN_DATA_MODEL_TYPE = "E4";
	public static final String DATA_MODEL_ERROR = "E5";
	public static final String BAD_CONTENT = "E6";
	public static final String SEND_FAIL = "E7";
	public static final String UNKOWN_ERROR= "EF";
}
