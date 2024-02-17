package com.feb.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.SingleColumnRowMapper;

public class MemberRowMapper extends SingleColumnRowMapper<Member> {
	
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setMemberIdx(rs.getInt("member_idx"));
		member.setMemberId(rs.getString("member_id"));
		member.setPasswd(rs.getString("passwd"));
		member.setEmail(rs.getString("email"));
		member.setJoinDtm(rs.getString("join_dtm"));
		return member;
	}
}