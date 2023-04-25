package com.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.dto.AuthInfo;
import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import com.example.list.dto.ListDTO;


@CrossOrigin("*")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder encodePassword;

	public MemberController() {
	}
	
	@GetMapping("/printrandom") // json객체를 java객체로 변환해야하기 때문에 requestbody사용
	public List<ListDTO> printRandom() {
		System.out.println("요청 들어옴");
		List<ListDTO> aList= memberService.randomService();
		System.out.println(aList.size());
		return aList; 
	}
	
	//회원가입 처리
		@PostMapping("/register")
		public String addMember(@RequestBody MemberDTO memberDTO) {
			memberDTO.setPassword(encodePassword.encode(memberDTO.getPassword()));
			AuthInfo authInfo = memberService.addMemberProcess(memberDTO);
			return null;
		}//addMember
		
		//회원정보 가져오기
		@GetMapping("/member/editinfo/{email}")
		public MemberDTO getMember(@PathVariable("email")String email) {
			return memberService.updateMembersProcess(email);
		}
		
		@PostMapping("/member/update")
		public void updateMember(@RequestBody MemberDTO memberDTO) {
			memberDTO.setPassword(encodePassword.encode(memberDTO.getPassword()));
			memberService.updateMemberProcess(memberDTO);
		}
	

	
}
