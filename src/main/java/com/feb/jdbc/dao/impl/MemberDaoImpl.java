package com.feb.jdbc.dao.impl;

import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.MemberDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.entity.MemberRowMapper;
import com.feb.jdbc.util.Sha512Encoder;

public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao {

	@Override
	public HashMap<String, Object> findMember(String memberId) {
		String sql = "select * from lecture.member where member_id = '" + memberId + "'";
		HashMap<String, Object> list = (HashMap<String, Object>) 
				getJdbcTemplate().queryForObject(sql, HashMap.class);
		return list;
	}
	
	public Member findMember2(String memberId) {
		String sql = "select member_idx, member_id, passwd, email, join_dtm from lecture.member where member_id = '" + memberId + "'";
		return getJdbcTemplate().queryForObject(sql, new MemberRowMapper());
	}

	@Override
	public ArrayList<Member> memberList(HashMap<String, Object> params) {
		int offset = Integer.parseInt((String) params.get("offset"));
		int limit = Integer.parseInt((String) params.get("limit"));
		String sql = "select member_idx as memberIdx, member_id as memberId, email, join_dtm as joinDtm"
				+ " from lecture.member offset " + offset + " limit " + limit;
		return (ArrayList<Member>) getJdbcTemplate().query(sql.toString(), new BeanPropertyRowMapper(Member.class));
	}

	@Override
	public int join(HashMap<String, String> params) {
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String passwd = params.get("passwd");
		String encodeTxt = encoder.getSecurePassword(passwd);
		String sql = "INSERT INTO lecture.member "
				+ "(member_id, passwd, email, join_dtm) "
				+ "VALUES('" + params.get("memberId")
				+ "', '" + encodeTxt
				+ "', '" + params.get("email")
				+ "', to_char(now(), 'YYYYMMDDHH24MISS'))";
		
		return getJdbcTemplate().update(sql);
	}

	@Override
	public int checkId(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<String, Object> getMemberById(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMember(String memberId, String email) {
		// 사실 select * 쓰면 x 쓰려는 컬럼만 가져와야 메모리 절약 / count()도 count(*)말고 count(1)쓰기
		// 여기선 일치하냐 판별할 거니까 숫자로 하는 게 효율적 - 1명
		String sql = "select count(1) from lecture.member where member_id = ? and email = ?";
		int result = getJdbcTemplate().queryForObject(sql, new Object[] {memberId, email}, Integer.class);
		return result;
	}

	@Override
	public int updatePasswd(String passwd, String memberId, String email) {
		String sql = "update lecture.member set passwd = ? where member_id = ? and email = ?";
		return getJdbcTemplate().update(sql, new Object[] {passwd, memberId, email});
	}	
}
