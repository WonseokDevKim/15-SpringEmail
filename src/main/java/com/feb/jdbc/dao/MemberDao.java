package com.feb.jdbc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface MemberDao {
	
	public HashMap<String, Object> findMember(String memberId);
	public Member findMember2(String memberId);
	
	public ArrayList<Member> memberList(HashMap<String, Object> params);

	public int join(HashMap<String, String> params);
	
	public int checkId(HashMap<String, String> params);
	
	public HashMap<String, Object> getMemberById(HashMap<String, String> params);
	
	// 사용자ID와 이메일로 사용자 찾기
	public int findMember(String memberId, String email);
	
	// 사용자의 비밀번호를 임시 비밀번호로 변경
	public int updatePasswd(String passwd, String memberId, String email);
}
