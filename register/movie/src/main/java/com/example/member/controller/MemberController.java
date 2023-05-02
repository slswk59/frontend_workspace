package com.example.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.file.FileUpload;
import com.example.member.dto.AuthInfo;
import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;


//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin("*")

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	//비밀번호를 암호화하여 전달하는 작업
	@Autowired
	private BCryptPasswordEncoder encodePassword;

	public MemberController() {

	}

	//회원가입 처리
	//@RequestBody첨부파일이 없는 경우 붙이고 있는 경우에는 붙이지 않는다. (json으로 내보내므로 필요)
	@PostMapping("/register")
	public String addMember(@RequestBody MemberDTO dto, HttpSession session) {
		System.out.println("요청");
		System.out.println(dto.getEmail());
		System.out.println(dto.getPassword());
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getGender());
		
		if(dto.getGender() == 0) {
			dto.setGender(1);
		} //리액트에서 디폴트값으로 gender값을 0을 보냈을때 강제로 gender값을 1로 변경해서 db저장함
		
		dto.setPassword(encodePassword.encode(dto.getPassword()));


		AuthInfo authInfo = memberService.addMemberProcess(dto);
		//authInfo를 정상적으로 받아오면 회원가입이 성공적으로 수행됬음을 의미한다. //받은 authInfo 데이터를 session에 저장한다.
		System.out.println(authInfo.getName());
		session.setAttribute("authInfo", authInfo);
		return null;
	} 

	//	//로그인 처리
	//	@PostMapping("/member/login")
	//	public String loginMember(MembersDTO membersDTO) {
	//		return "null";
	//	}
	
	//회원정보 가져오기
	@GetMapping("/member/editinfo/{email}")
	public MemberDTO getMember(@PathVariable("email") String email) {
		return memberService.updateMembersProcess(email);
	}
	
	//회원정보 수정 처리
	@PostMapping("/profile/update")
	public void updateMember(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
//	    UUID uuid = FileUpload.saveCopyFile(file, FileUpload.urlPath(request));
//	    memberDTO.setProfile_path(uuid + "_" + file.getOriginalFilename());
		System.out.println(memberDTO.getPassword());
	    memberDTO.setPassword(encodePassword.encode(memberDTO.getPassword()));
//	    memberDTO.setNickname(memberDTO.getNickname());
//	    System.out.println(memberDTO.getProfile_path());
	    memberService.updateMemberProcess(memberDTO);
	}
	
	@PostMapping("/profile/imgUpdate")
	public void updateprofileImg(@RequestParam("file") MultipartFile file, @RequestParam("email") String email, HttpServletRequest request) {
		System.out.println("Hello World");
		UUID uuid = FileUpload.saveCopyFile(file, FileUpload.urlPath(request));
	    System.out.println(uuid);
	    System.out.println(email);
	    MemberDTO member = memberService.selectByEmailProcess(email);
	    member.setProfile_path(uuid + "_" + file.getOriginalFilename());
	    System.out.println(member.getProfile_path());
	    System.out.println(member.getEmail());
	    memberService.updateProfileImgProcess(member);
	};

}//end class