package com.jip.dbapp.dao;

import com.jip.dbapp.dto.MemberDto;

public interface MemberDao {
	//패스워드를 가져오는 메소드
	public String getPwd(String id);
	//회원 가입 메소드
	public void memberInsert(MemberDto member);
	//
}
