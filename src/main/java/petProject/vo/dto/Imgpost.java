/*
========================================================================
파    일    명 : Imgpost.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : Imgpost DTO 객체
========================================================================
*/
package petProject.vo.dto;

import petProject.vo.Member;

public class Imgpost {

	private static final long serialVersionUID = 1L;
	private int imgpostNo;
	private String imgpostTitle;
	private int memberNumber;
	private String imgpostContent;
	private int imgpostAvailable;
	private String imgpostPostingtime;
	private int imgpostViewcnt;
	private Member member;

	public Imgpost(int imgpostNo, String imgpostTitle, int memberNumber, String imgpostContent, int imgpostAvailable,
			String imgpostPostingtime, int imgpostViewcnt, Member member) {
		super();
		this.imgpostNo = imgpostNo;
		this.imgpostTitle = imgpostTitle;
		this.memberNumber = memberNumber;
		this.imgpostContent = imgpostContent;
		this.imgpostAvailable = imgpostAvailable;
		this.imgpostPostingtime = imgpostPostingtime;
		this.imgpostViewcnt = imgpostViewcnt;
		this.member = member;
	}

	public Imgpost() {
		super();
	}

	public int getImgpostNo() {
		return imgpostNo;
	}

	public void setImgpostNo(int imgpostNo) {
		this.imgpostNo = imgpostNo;
	}

	public String getImgpostTitle() {
		return imgpostTitle;
	}

	public void setImgpostTitle(String imgpostTitle) {
		this.imgpostTitle = imgpostTitle;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getImgpostContent() {
		return imgpostContent;
	}

	public void setImgpostContent(String imgpostContent) {
		this.imgpostContent = imgpostContent;
	}

	public int getImgpostAvailable() {
		return imgpostAvailable;
	}

	public void setImgpostAvailable(int imgpostAvailable) {
		this.imgpostAvailable = imgpostAvailable;
	}

	public String getImgpostPostingtime() {
		return imgpostPostingtime;
	}

	public void setImgpostPostingtime(String imgpostPostingtime) {
		this.imgpostPostingtime = imgpostPostingtime;
	}

	public int getImgpostViewcnt() {
		return imgpostViewcnt;
	}

	public void setImgpostViewcnt(int imgpostViewcnt) {
		this.imgpostViewcnt = imgpostViewcnt;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
