package com.jip.dbapp.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jip.dbapp.dao.MemberDao;
import com.jip.dbapp.dto.MemberDto;

@Service
public class HomeService {
	//로그인, 회원가입 처리 기능
	//DAO 객체, 세션 객체, ModelAndView 객체
	@Autowired
	private MemberDao mDao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mv;
	
	//로그인 처리용 메소드
	public ModelAndView loginProc(MemberDto member, 
			RedirectAttributes rttr) {
		mv = new ModelAndView();
		
		String view = null;//이동할 페이지 저장 변수
		String msg = null;//메시지 저장 변수
		
		//DB에서 해당 id의 비밀번호 구하기.
		String get_pw = mDao.getPwd(member.getM_id());
		
		//로그인 처리
		if(get_pw != null) {
			//가입한 회원.
			if(get_pw.equals(member.getM_pwd())) {
				//로그인 성공.
				//세션에 로그인 성공 관련 데이터 저장
				session.setAttribute("id", member.getM_id());
				
				//리다이렉트로 화면을 전환(main.jsp)
				view = "redirect:main";
			}
			else {
				//비밀번호 틀림. 리다이렉트로 로그인화면으로 이동.
				view = "redirect:loginFrm";
				msg = "비밀번호 오류";
			}
		}
		else {
			//회원이 아니다. 리다이렉트로 로그인화면으로 이동.
			view = "redirect:loginFrm";
			msg = "아이디 없음";
		}
		
		mv.setViewName(view);
		rttr.addFlashAttribute("msg", msg);
		
		return mv;
	}
	
	public ModelAndView memberInsert(MemberDto member,
			RedirectAttributes rttr) {
		mv = new ModelAndView();
		
		String view = null;
		String msg = null;
		
		try {
			mDao.memberInsert(member);
			
			view = "redirect:/";
			msg = "가입 성공";
		} catch (Exception e) {
			//e.printStackTrace();
			view = "redirect:joinFrm";
			msg = "아이디 중복";
		}
		
		mv.setViewName(view);
		rttr.addFlashAttribute("msg", msg);
		
		return mv;
	}
	
}//class end




