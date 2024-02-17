package com.feb.jdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.entity.Member;
import com.feb.jdbc.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@ResponseBody
	@RequestMapping("/findMember.do")
	public String findMember(@RequestParam HashMap<String, String> params) {
		String memberId = params.get("memberId");
		Member member = memberService.findMember2(memberId);
//		HashMap<String, Object> map = memberService.findMember(memberId);
		return member.getMemberId();
	}
	
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.join(params);
		mv.setViewName("login");
		mv.addObject("resultCode", result);
		if (result == 1) {
			mv.addObject("resultMsg", "회원가입 성공");
		} else {
			mv.addObject("resultMsg", "회원가입 실패");
		}
		return mv;
	}
	
	@GetMapping("/list.do")
	public ModelAndView memberList(@RequestParam HashMap<String, Object> params) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberList", memberService.memberList(params));
		mv.setViewName("list");
		return mv;		
	}
	
	@GetMapping("/findPw.do")
	public ModelAndView findPw(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		boolean result = memberService.findPasswd(params);
		mv.setViewName("common/broker");
		mv.addObject("resultCode", result);
		mv.addObject("nextUri", "/loginPage.do");
		if (result) {
			mv.addObject("resultCode", "ok");
			mv.addObject("resultMsg", "이메일로 임시 비밀번호 발송함");
		} else {
			mv.addObject("resultMsg", "사용자가 없어요.");
		}
		return mv;
	}
}











