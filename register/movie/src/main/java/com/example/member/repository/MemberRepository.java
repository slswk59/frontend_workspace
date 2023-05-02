package com.example.member.repository;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
	}


