package com.feb.jdbc.dao;

import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface LoginDao {
	public Member login(String memberId);
}
