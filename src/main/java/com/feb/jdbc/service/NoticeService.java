package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.feb.jdbc.dao.NoticeDao;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {}
	public NoticeService(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	public int write(HashMap<String, String> params) {
		return noticeDao.write(params);
	}

}
