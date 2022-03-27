package com.zerobase.fast_lms.member.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zerobase.fast_lms.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Optional<Member> findByEmailAuthKey(String emailAuthKey);
	
	
}
