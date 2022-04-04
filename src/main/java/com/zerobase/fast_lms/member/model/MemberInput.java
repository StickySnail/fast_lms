package com.zerobase.fast_lms.member.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data

public class MemberInput {

	private String userId;
	private String userName;
	private String password;
	private String phone;
	
	@Override
	public String toString() {
		return String.format("userId: %s userName: %s password: %s phone: %s", getUserId(), getUserName(), getPassword(), getPhone());
	}
}
