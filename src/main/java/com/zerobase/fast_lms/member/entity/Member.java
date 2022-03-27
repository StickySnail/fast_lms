package com.zerobase.fast_lms.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class Member {
	
	@Id
	@Column
	private String userId;
	
	private String userName;
	private String password;
	private String phone;
	private LocalDateTime regDt;
	
	private boolean emailAuthYn;
	private String emailAuthKey;
	
	private LocalDateTime emailAuthDt;
	
	 
	public LocalDateTime getEmailAuthDt() {
		return emailAuthDt;
	}
	public void setEmailAuthDt(LocalDateTime emailAuthDt) {
		this.emailAuthDt = emailAuthDt;
	}
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
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	public boolean isEmailAuthYn() {
		return emailAuthYn;
	}
	public void setEmailAuthYn(boolean emailAuthYn) {
		this.emailAuthYn = emailAuthYn;
	}
	public String getEmailAuthKey() {
		return emailAuthKey;
	}
	public void setEmailAuthKey(String emailAuthKey) {
		this.emailAuthKey = emailAuthKey;
	}
	

}
