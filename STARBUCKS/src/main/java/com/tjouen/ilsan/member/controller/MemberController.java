package com.tjouen.ilsan.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjouen.ilsan.member.service.MemberService;

@Controller // 1. Controller annotation + servlet-context에 <context:component-scan base-package="com.tjouen.ilsan" /> 로 스캔
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired // new하지 않고 memberService di 자동으로 bean이 singletone으로 inject된다
	MemberService memberservice;
	
	
	@RequestMapping(value="/member/list", method = RequestMethod.GET) // member/list로 들어오면 메소드 실행 get방식
	public String memberList (@RequestParam(value = "memberId") String memberId
			, Model model//mvc모델 객체에 담아 놓으면 view에서쓸수있음 모델앤뷰는 옛날 소스
			, HttpServletRequest req //이렇게하면 req도 알아서 들어온다
			) { //param 데이터를 annotation으로 받아 memberId에 저장
		
		// 2. Model
		logger.debug("memberId:"+ memberId); //로그 레벨 info warning debug로 찍을 수 있음 실제 서버에서는 디버깅이 안되서 흔적 남기려고 사용 log4j도 debug로 바꿔야함
		memberservice.getMemberList();
		
		// 3. View
		model.addAttribute("memberId", memberId);
		
		return "member/memberList"; //return이 forward
		
	}

}
