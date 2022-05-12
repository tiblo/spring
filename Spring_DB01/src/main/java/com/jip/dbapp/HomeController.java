package com.jip.dbapp;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jip.dbapp.dto.MemberDto;
import com.jip.dbapp.service.HomeService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeService hServ;
	
	private ModelAndView mv;
	
	@GetMapping("/")
	public String home() {
		logger.debug("home()");
		
		return "home";
	}
	
	@GetMapping("loginFrm")
	public String loginFrm() {
		logger.info("loginFrm()");
		
		return "loginFrm";
	}
	
	@GetMapping("joinFrm")
	public String joinFrm() {
		logger.info("joinFrm()");
		
		return "joinFrm";
	}
	
	@PostMapping("loginProc")
	public ModelAndView loginProc(MemberDto member, 
			RedirectAttributes rttr) {
		logger.info("loginProc()");
		
		mv = hServ.loginProc(member, rttr);
		
		return mv;
	}
	
	@GetMapping("main")
	public String mainPage() {
		logger.info("mainPage()");
		
		return "main";
	}
	
	@PostMapping("memInsert")
	public ModelAndView memberInsert(MemberDto member,
			RedirectAttributes rttr) {
		logger.info("memberInsert()");
		
		mv = hServ.memberInsert(member, rttr);
		
		return mv;
	}
	
}//class end





