package com.zerobase.fast_lms.member.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zerobase.fast_lms.components.MailComponents;
import com.zerobase.fast_lms.member.entity.Member;
import com.zerobase.fast_lms.member.model.MemberInput;
import com.zerobase.fast_lms.member.repository.MemberRepository;
import com.zerobase.fast_lms.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 작동 안하는듯 
@Service
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	private final MailComponents mailComponents;
	
	/**
	 * 회원 가입
	 */
	@Override
	public boolean register(MemberInput parameter) {
		
		Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
		
		if(optionalMember.isPresent()) {
			//현재 userId에 해당하는 데이터 존재
			return false;
		}
		
		String uuid = UUID.randomUUID().toString();
		
		
		//builder 어노테이션이 먹혀야 쓸 수 있음 / 이렇게 깔끔하게 표현 가능.
		Member member = Member.builder()
				.userId(parameter.getUserId())
				.userName(parameter.getUserName())
				.phone(parameter.getPhone())
				.password(parameter.getPassword())
				.regDt(LocalDateTime.now())
				.emailAuthYn(false)
				.emailAuthKey(uuid)
				.build();
		memberRepository.save(member);
		
		
		/*
		Member member = new Member();
		member.setUserId(parameter.getUserId());
		member.setUserName(parameter.getUserName());
		member.setPhone(parameter.getPhone());
		member.setPassword(parameter.getPassword());
		member.setRegDt(LocalDateTime.now());
		member.setEmailAuthYn(false);
		member.setEmailAuthKey(uuid);
		memberRepository.save(member);
		*/
		
		String email = parameter.getUserId();
		String subject = "fastlms 사이트 가입을 축하드립니다.";
		String text = "<p>fastlms 사이트 가입을 축하드립니다.</p><p>아래 링크를 클릭하셔서 가입을 완료 하세요</p>"
				+ "<div><a target='_blank' href ='http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입 완료</a></div>";
		mailComponents.sendMail(email,  subject, text);
		
		return true;
	}



	@Override
	public boolean emailAuth(String uuid) {
		
		Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
		if(!optionalMember.isPresent()) {
			return false;
		}
		
		Member member = optionalMember.get();
		member.setEmailAuthYn(true);
		member.setEmailAuthDt(LocalDateTime.now());
		memberRepository.save(member);
		
		
		return false;
	}
	
	

}
