package com.example.shop.members.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.common.exception.WrongEmailPasswordException;
import com.example.shop.members.dao.MembersDAO;
import com.example.shop.members.dto.AuthInfo;
import com.example.shop.members.dto.ChangePwdCommand;
import com.example.shop.members.dto.MembersDTO;

@Service
public class MembersServiceImp implements MembersService {
	
	@Autowired
	private MembersDAO membersDao;
	
	public MembersServiceImp() {
		
	}

	@Override
	public AuthInfo addMemberProcess(MembersDTO dto) {
		membersDao.insertMember(dto);
		return new AuthInfo(dto.getMemberEmail(), dto.getMemberName(), dto.getMemberPass());
	}

	@Override
	public AuthInfo loginProcess(MembersDTO dto) {
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		
		//받은Email값이 일치하는 것이 있으면 dto, 일치하는것이 없다면 null 리턴
		if(member == null) {
			//System.out.println("회원이 아닙니다.");
			//사용자가 고의로 예외를 발생시킬 경우 throw
			throw new WrongEmailPasswordException();
		}

		//memberPass와 일치하는지 확인
		if(!member.matchPassword(dto.getMemberPass())) {
			//System.out.println("비밀번호가 다릅니다.");
			throw new WrongEmailPasswordException();
		}
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
	}

	@Override
	public MembersDTO updateMemberProcess(String memberEmail) {
		return membersDao.selectByEmail(memberEmail);
	}

	@Override
	public AuthInfo updateMemberProcess(MembersDTO dto) {
		membersDao.updateMember(dto);
		
		//회원정보 수정 후 (" "님 로그아웃) 업데이트
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {
		MembersDTO member = membersDao.selectByEmail(memberEmail); //email에 대한 정보 가져옴
		if(member == null)
			throw new WrongEmailPasswordException();
		
		//가져온 비밀번호와 기존의 비밀번호(String memberEmail)가 같은지 확인해야한다.
		member.changePassword(changePwd.getCurrentPassword(), changePwd.getNewPassword());
		membersDao.updateByPass(member);
		
	}//end updatePassProcess
	
}//end class
