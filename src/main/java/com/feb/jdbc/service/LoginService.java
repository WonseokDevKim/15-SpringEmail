package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.util.StringUtils;

import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.util.Sha512Encoder;

public class LoginService {
	
	private LoginDao loginDao;
	
	public LoginService() {}
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	// 가급적 dao에 있는 메서드 선언부 일치시키기 - 단 여기서는 조금 바꿈
	public boolean login(HashMap<String, String> params) {
		String memberId = params.get("memberId");
		Member member = loginDao.login(memberId);
		String memberPw = member.getPasswd(); // DB에 있는 값
		
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String passwd = params.get("passwd"); // 사용자가 입력한 값
		// 사용자가 입력한 값을 암호화한 것
		String encodeTxt = encoder.getSecurePassword(passwd);
		
		System.out.println(member);
		// org.springframework.util.StringUtils
		return StringUtils.pathEquals(memberPw, encodeTxt);
	}
}
