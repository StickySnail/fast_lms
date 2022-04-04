package com.zerobase.fast_lms;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()  //모든 페이지에 대해 접근 가능하게 하겠다는 표현 == "/**/ (spring security에 대하여)
		.antMatchers(
				"/",
				"/member/register",
				"/member/email-auth"
				 ) //위 3개의 주소는 로그인 없이 접근 가능하게 한 것 임
		
		.permitAll();
		
		
		http.formLogin()
		.loginPage("/member/login")
		.failureHandler(null) // 로그인 실패했을때 처리
		.permitAll();
		
		
		
		
		super.configure(http);
	}
	
	
	
	
	
	

}
