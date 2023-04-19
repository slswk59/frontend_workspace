package com.example.shop.members.service;

import com.example.shop.members.dto.AuthInfo;
import com.example.shop.members.dto.ChangePwdCommand;
import com.example.shop.members.dto.MemberDTO;

public interface MembersService {
	
	public AuthInfo addMemberProcess(MemberDTO dto);
	public AuthInfo loginProcess(MemberDTO dto);
	
	public MemberDTO updateMemberProcess(String memberEmail);
	public AuthInfo updateMemberProcess(MemberDTO dto);
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd);

}
