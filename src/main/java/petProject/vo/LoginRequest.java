/*
========================================================================
파    일    명 : LoginRequest.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 사용자로부터 입력받은 Login정보
========================================================================
*/
package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	private String id;

	@NotBlank
	private String password;

	private boolean memory;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String id, String password, boolean memory) {
		super();
		this.id = id;
		this.password = password;
		this.memory = memory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}

}
