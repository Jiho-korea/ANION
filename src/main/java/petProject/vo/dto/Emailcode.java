package petProject.vo.dto;

import java.util.Random;

public class Emailcode {

	private int emailcodeNumber;
	private String memberId;
	private String emailCode;
	private String newMemberId;

	public int getEmailcodeNumber() {
		return emailcodeNumber;
	}

	public void setEmailcodeNumber(int emailcodeNumber) {
		this.emailcodeNumber = emailcodeNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getNewMemberId() {
		return newMemberId;
	}

	public void setNewMemberId(String newMemberId) {
		this.newMemberId = newMemberId;
	}

	public static String random() {
		Random rand = new Random();
		String numStr = "";

		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));

			numStr += ran;
		}
		return numStr;
	}

}
