package com.example.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.member.dto.MemberDTO;

@Mapper
@Repository
public interface MemberDAO {

	public int insertMember(MemberDTO dto);
	public MemberDTO selectByEmail(String email);
	
	public void updateMember(MemberDTO dto);
	public void updateByPass(MemberDTO dto);
	public void updateProfileImage(MemberDTO member);
	
}