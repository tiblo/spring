package com.jip.dbapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.jip.dbapp.dto.MemberDto;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class MemServiceTest {
	@Autowired
	private HomeService hServ;//서비스 객체 가져오기
	
	@Test //bean이 정상적으로 생성되었는지 확인
	public void testExist() {
		log.info(hServ.toString());
		assertNotNull(hServ);//객체가 Null인지의 여부 검사
	}
	
	@Test //로그인 처리 메소드가 잘 동작하는지 확인
	public void testLoginProc() {
		//임시 입력 데이터 객체 생성 및 데이터 입력
		MemberDto member = new MemberDto();
		member.setM_id("test01");
		member.setM_pwd("1111");
		
		ModelAndView mv = hServ.loginProc(member, null);
		log.info(mv.getViewName());
	}
}



