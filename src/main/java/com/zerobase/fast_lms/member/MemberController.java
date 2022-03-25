package com.zerobase.fast_lms.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	
	//@RequestMapping(value = "/member/register", method = RequestMethod.GET)
	@GetMapping("/member/register")
	public String register() {
		
		return "member/register";

	}
	
	//@RequestMapping(value = "member/register", method = RequestMethod.POST)
	@PostMapping("/member/register")
	public String registerSubmit(HttpServletRequest request, HttpServletResponse response, 
			MemberInput parameter) {
		
		System.out.println(parameter.toString());
		
		return "member/register";

	}

}
