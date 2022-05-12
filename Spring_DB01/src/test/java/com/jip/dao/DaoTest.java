package com.jip.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jip.dbapp.dao.MemberDao;
import com.jip.dbapp.dto.MemberDto;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class DaoTest {
	@Autowired
	private MemberDao mDao;
	
	@Test
	public void testGetPwd() {
		log.info(mDao.getPwd("test01"));
	}
	
	@Test
	public void testMemIn() {
		log.info("testMemIn()");
		MemberDto member = new MemberDto();
		member.setM_id("user01");
		member.setM_name("사용자01");
		member.setM_age(25);
		member.setM_addr("어딘가");
		member.setM_pwd("1111");
		
		mDao.memberInsert(member);
	}
}



