package com.example.member.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.list.dto.ListDTO;
import com.example.member.dto.MemberDTO;

@Mapper
@Repository
public interface MemberDAO {
	public List<ListDTO> printRandom();
	public void review(String comment);
	
	public int insertMember(MemberDTO dto);
	public MemberDTO selectByEmail(String email);
	
	public void updateProfileImg(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void updateByPass(MemberDTO dto);
	
	public List<String> emailCheck();
}