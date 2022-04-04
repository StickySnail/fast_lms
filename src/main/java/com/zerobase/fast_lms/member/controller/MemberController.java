package com.zerobase.fast_lms.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zerobase.fast_lms.member.model.MemberInput;
import com.zerobase.fast_lms.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class MemberController {


	private final MemberService memberService;

	
	
	// @RequestMapping(value = "/member/register", method = RequestMethod.GET)
	@GetMapping("/member/register")
	public String register() {

		return "member/register";

	}

	// @RequestMapping(value = "member/register", method = RequestMethod.POST)
	@PostMapping("/member/register")
	public String registerSubmit(Model model, HttpServletRequest request
			, MemberInput parameter) {

		boolean result = memberService.register(parameter);
		model.addAttribute("result", result);

		parameter.toString();

		return "member/register_c";
	}
	
	// <정보>
	// http://www.naver.com/news/list.do?id=123
	// ex) http://~ :80/news/~ 80포트임 ( 웹포트의 디폴트라 생략 가능)
	// ex) https://~ :443/ 443포트 (https의 디폴트)
	// 프로토콜://도메인(IP)/news/list.do
	// http://www.naver.com/cafe/detail.do?id=123
	// http://www.naver.com/cafe/detail.do?id=12312
	// ? 뒤에는 parameter임 쿼리스트링!
	
	@GetMapping("/member/email-auth")
	public String emailAuth(Model model, HttpServletRequest request)	{
		
		String uuid = request.getParameter("id");
		System.out.println(uuid);
		
		boolean result = memberService.emailAuth(uuid);
		model.addAttribute("result", result); //result 값을 view에 담기위해 모델에 담음
		return "member/email_auth";
	}
	
	@GetMapping("/member/info")
	public String memberInfo() {
		return "member/info";
	}
	

}
