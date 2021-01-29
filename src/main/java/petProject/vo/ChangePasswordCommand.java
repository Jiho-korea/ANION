/*
========================================================================
파    일    명 : ChangePasswordCommand.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.30
작  성  내  용 : 비밀번호를 변경하기위한 command
========================================================================
*/

package petProject.vo;

import org.hibernate.validator.constraints.NotBlank;

public class ChangePasswordCommand {

	@NotBlank
	private String currentPassword;
	@NotBlank
	private String newPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
