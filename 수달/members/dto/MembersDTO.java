package com.example.shop.members.dto; //members 테이블 자원

import org.springframework.stereotype.Component;

import com.example.shop.common.exception.*;

@Component
public class MembersDTO {
	
	private String memberEmail; //이메일
	private String memberPass;  //비밀번호
	private String memberName;  //이름
	private String memberPhone; //전화번호
	private int memberType;	     //회원구분 일반회원1, 관리자2
	private boolean rememberEmail; //자동 로그인
	private String authRole;
	private String profileImageFilePath; // 프로필 이미지 파일 경로
	
	
	public String getProfileImageFilePath() {
		return profileImageFilePath;
	}

	public void setProfileImageFilePath(String profileImageFilePath) {
		this.profileImageFilePath = profileImageFilePath;
	}

	public MembersDTO() {
		
	}

	public String getAuthRole() {
		return authRole;
	}

	public void setAuthRole(String authRole) {
		this.authRole = authRole;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
		        //DB에 입력되어있는 pw와  입력한 pw가 동일한지
	}
	
	//DB에 입력되어있는 pw와 현재비밀번호입력의 pw가 동일한지 확인해야한다.
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.memberPass.equals(oldPassword)) //본인인지 인증하기 위함이다.
			throw new WrongEmailPasswordException();
		this.memberPass = newPassword;
	}
	
}//end class
