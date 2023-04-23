package com.example.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.exception.WrongEmailPasswordException;
import com.example.member.dao.MemberDAO;
import com.example.member.dto.AuthInfo;
import com.example.member.dto.ChangePwdCommand;
import com.example.member.dto.MemberDTO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDAO membersDao;
	
	public MemberServiceImp() {
		
	}

	@Override
	public AuthInfo addMemberProcess(MemberDTO dto) {
	   
        
		membersDao.insertMember(dto);
		return new AuthInfo(dto.getEmail(), dto.getUserName(), dto.getPassWord());
	}

	@Override
	public AuthInfo loginProcess(MemberDTO dto) {
		MemberDTO member = membersDao.selectByEmail(dto.getEmail());
		
		//받은Email값이 일치하는 것이 있으면 dto, 일치하는것이 없다면 null 리턴
		if(member == null) {
			//System.out.println("회원이 아닙니다.");
			//사용자가 고의로 예외를 발생시킬 경우 throw
			throw new WrongEmailPasswordException();
		}

		//memberPass와 일치하는지 확인
		if(!member.matchPassword(dto.getPassWord())) {
			//System.out.println("비밀번호가 다릅니다.");
			throw new WrongEmailPasswordException();
		}
		return new AuthInfo(member.getEmail(), member.getUserName(), member.getPassWord());
	}

	@Override
	public MemberDTO updateMemberProcess(String memberEmail) {
		return membersDao.selectByEmail(memberEmail);
	}

	@Override
	public AuthInfo updateMemberProcess(MemberDTO dto) {
		membersDao.updateMember(dto);
		
		//회원정보 수정 후 (" "님 로그아웃) 업데이트
		MemberDTO member = membersDao.selectByEmail(dto.getEmail());
		return new AuthInfo(member.getEmail(), member.getUserName(), member.getPassWord());
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {
		MemberDTO member = membersDao.selectByEmail(memberEmail); //email에 대한 정보 가져옴
		if(member == null)
			throw new WrongEmailPasswordException();
		
		//가져온 비밀번호와 기존의 비밀번호(String memberEmail)가 같은지 확인해야한다.
		member.changePassword(changePwd.getCurrentPassword(), changePwd.getNewPassword());
		membersDao.updateByPass(member);
		
	}//end updatePassProcess
	
}//end class
