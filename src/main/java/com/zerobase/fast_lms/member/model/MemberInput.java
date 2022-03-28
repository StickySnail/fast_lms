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

	//getter setter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
