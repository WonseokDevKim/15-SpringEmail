package com.feb.jdbc.entity;

public class Member {
	int memberIdx;
	String memberId;
	String passwd;
	String email;
	String joinDtm;
	
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDtm() {
		return joinDtm;
	}
	public void setJoinDtm(String joinDtm) {
		this.joinDtm = joinDtm;
	}
	
	@Override
	public String toString() {
		return "Member [memberIdx=" + memberIdx + ", memberId=" + memberId + ", passwd=" + passwd + ", email=" + email
				+ ", joinDtm=" + joinDtm + "]";
	}
	
}
