package com.example.member.service;

import com.example.member.dto.AuthInfo;
import com.example.member.dto.ChangePwdCommand;
import com.example.member.dto.MemberDTO;

public interface MemberService {
	
	public AuthInfo addMemberProcess(MemberDTO dto);
	public AuthInfo loginProcess(MemberDTO dto);
	
	public MemberDTO updateMemberProcess(String memberEmail);
	public AuthInfo updateMemberProcess(MemberDTO dto);
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd);

}
