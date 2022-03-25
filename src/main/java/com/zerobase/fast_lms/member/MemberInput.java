package com.zerobase.fast_lms.member;

import lombok.Data;

import lombok.ToString;

@ToString
@Data
public class MemberInput {

	private String userId;
	private String userName;
	private String password;
	private String phone;
	
	
}