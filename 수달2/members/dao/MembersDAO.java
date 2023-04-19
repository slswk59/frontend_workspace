package com.example.shop.members.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.shop.members.dto.MemberDTO;

@Mapper
@Repository
public interface MembersDAO {

	public int insertMember(MemberDTO dto);
	public MemberDTO selectByEmail(String memberEmail);
	
	public void updateMember(MemberDTO dto);
	public void updateByPass(MemberDTO dto);
	public void updateProfileImage(MemberDTO member);
	
}