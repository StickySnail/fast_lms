package com.zerobase.fast_lms.member.service;

import com.zerobase.fast_lms.member.model.MemberInput;

public interface MemberService {
	
	boolean register(MemberInput parameter);
	
	/*
	 * uuid에 해당하는 계정을 활성화 합니다.
	 */
	boolean emailAuth(String uuid);

}
