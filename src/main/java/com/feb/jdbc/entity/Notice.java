package com.feb.jdbc.entity;

public class Notice {
	int noticeIdx;
	String author;
	String content;
	String wrt_dtm;
	public int getNoticeIdx() {
		return noticeIdx;
	}
	public void setNoticeIdx(int noticeIdx) {
		this.noticeIdx = noticeIdx;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrt_dtm() {
		return wrt_dtm;
	}
	public void setWrt_dtm(String wrt_dtm) {
		this.wrt_dtm = wrt_dtm;
	}
	
	
}
