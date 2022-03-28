package com.zerobase.fast_lms.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	

}
