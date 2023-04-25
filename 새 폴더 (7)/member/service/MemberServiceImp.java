package com.example.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.exception.WrongEmailPasswordException;
import com.example.list.dto.ListDTO;
import com.example.member.dao.MemberDAO;
import com.example.member.dto.AuthInfo;
import com.example.member.dto.ChangePwdCommand;
import com.example.member.dto.MemberDTO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;

	public MemberServiceImp() {
	}
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<ListDTO> randomService() {
		// TODO Auto-generated method stub
		List<ListDTO> memberList=memberDao.printRandom();
		return memberList;
	}
	@Override
	public void reviewService(String comment) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public AuthInfo addMemberProcess(MemberDTO dto) {
		memberDao.insertMember(dto);
		return new AuthInfo(dto.getEmail(), dto.getName(), dto.getPassword());
	}

	@Override
	public AuthInfo loginProcess(MemberDTO dto) {
		MemberDTO member =  memberDao.selectByEmail(dto.getEmail());
		if(member == null) {
			//System.out.println("회원이 아닙니다.");
			throw new WrongEmailPasswordException();
		}
		
		if(!member.matchPassword(dto.getPassword())) {
			//System.out.println("비밀번호가 다릅니다.");
			throw new WrongEmailPasswordException();
		}
		
		return new AuthInfo(member.getEmail(), member.getName(), member.getPassword());
	}

	@Override
	public MemberDTO updateMembersProcess(String email) {
		
		return memberDao.selectByEmail(email);
	}

	@Override
	public AuthInfo updateMemberProcess(MemberDTO dto) {
		memberDao.updateMember(dto);
		MemberDTO member =  memberDao.selectByEmail(dto.getEmail());
		return new AuthInfo(member.getEmail(), member.getName(), member.getPassword());
	}

	@Override
	public void updatePassProcess(String email, ChangePwdCommand changePwd) {
		MemberDTO member = memberDao.selectByEmail(email);
		if(member == null)
			throw new WrongEmailPasswordException();
		
		member.changePassword(changePwd.getCurrentPassword(), changePwd.getNewPassword());
		memberDao.updateByPass(member);
		
	}
	
}
