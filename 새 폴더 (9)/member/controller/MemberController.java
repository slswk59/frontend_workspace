package com.example.member.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String addMember(@RequestBody MemberDTO memberDTO, HttpSession session) {
		System.out.println("요청");
		System.out.println(memberDTO.getEmail());
		System.out.println(memberDTO.getPassword());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getAge());
		System.out.println(memberDTO.getGender());
		
		
		memberDTO.setPassword(encodePassword.encode(memberDTO.getPassword()));

		AuthInfo authInfo = memberService.addMemberProcess(memberDTO);
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
	public void updateMember(@RequestParam("file") MultipartFile file, @RequestBody MemberDTO memberDTO, HttpServletRequest request) {
	    if (!file.isEmpty()) {
	        String filePath = FileUpload.urlPath(request); // 파일이 저장될 경로를 지정합니다.
	        UUID uuid = FileUpload.saveCopyFile(file, filePath); // 파일을 저장하고, UUID 값을 받습니다.
	        
	        // 파일 업로드가 완료되면 DB에 UUID 값을 저장합니다.
	        memberDTO.setProfile_path(filePath);
	    }
	    
	    memberDTO.setPassword(encodePassword.encode(memberDTO.getPassword()));
	    memberService.updateMemberProcess(memberDTO);
	}

}//end class