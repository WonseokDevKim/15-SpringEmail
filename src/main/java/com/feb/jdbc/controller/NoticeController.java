package com.feb.jdbc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/write.do")
	public ModelAndView write(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.write(params);
		mv.setViewName("notice");
		if (result == 1) {
			mv.addObject("resultMsg", "게시물이 성공적으로 등록되었습니다.");
		} else {
			mv.addObject("resultMsg", "게시물이 등록에 실패했습니다.");
		}
		return mv;
	}
}
