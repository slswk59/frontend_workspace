package com.example.shop.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.members.dto.AuthInfo;
import com.example.shop.members.dto.MembersDTO;
import com.example.shop.members.service.MembersService;


//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin("*")

@RestController
public class MembersController {

	@Autowired
	private MembersService membersService;

	//비밀번호를 암호화하여 전달하는 작업
	@Autowired
	private BCryptPasswordEncoder encodePassword;

	public MembersController() {

	}

	//회원가입 처리
	//@RequestBody첨부파일이 없는 경우 붙이고 있는 경우에는 붙이지 않는다. (json으로 내보내므로 필요)
	@PostMapping("/register")
	public String addMember(@RequestBody MembersDTO membersDTO, HttpSession session) {
		System.out.println("요청");
		System.out.println(membersDTO.getMemberPass());
		System.out.println(membersDTO.getMemberName());
		membersDTO.setMemberPass(encodePassword.encode(membersDTO.getMemberPass()));

		AuthInfo authInfo = membersService.addMemberProcess(membersDTO);
		//authInfo를 정상적으로 받아오면 회원가입이 성공적으로 수행됬음을 의미한다. //받은 authInfo 데이터를 session에 저장한다.
		session.setAttribute("authInfo", authInfo);
		return null;
	}

	//	//로그인 처리
	//	@PostMapping("/member/login")
	//	public String loginMember(MembersDTO membersDTO) {
	//		return "null";
	//	}
	
	//회원정보 가져오기
	@GetMapping("/member/editinfo/{}")
	public MembersDTO getMember(@PathVariable("memberEmail") String memberEmail) {
		return membersService.updateMemberProcess(memberEmail);
	}
	
	//회원정보 수정 처리
	@PostMapping("/member/update")
	public void updateMember(@RequestBody MembersDTO membersDTO) {
		membersDTO.setMemberPass(encodePassword.encode(membersDTO.getMemberPass()));
		membersService.updateMemberProcess(membersDTO);
		
	}


}//end class