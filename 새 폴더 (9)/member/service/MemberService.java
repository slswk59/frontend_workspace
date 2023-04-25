package com.example.member.service;

import java.util.List;

import com.example.list.dto.ListDTO;
import com.example.member.dto.AuthInfo;
import com.example.member.dto.ChangePwdCommand;
import com.example.member.dto.MemberDTO;

public interface MemberService {
	public List<ListDTO> randomService();
	public void reviewService(String comment);
	
	public AuthInfo addMemberProcess(MemberDTO dto);
	public AuthInfo loginProcess(MemberDTO dto); 
	
	public MemberDTO updateMembersProcess(String email);
	public AuthInfo updateMemberProcess(MemberDTO dto);
	public void updatePassProcess(String email, ChangePwdCommand changePwd);
}
