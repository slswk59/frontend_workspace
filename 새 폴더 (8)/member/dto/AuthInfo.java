package com.example.member.dto;

//로그인 성공 후 인증 상태 정보를 세션에 보관할 때 사용한다.
public class AuthInfo {
	
	private String email;
	private String name;
	private String password;
	private int age;
	private int gender;
	
	

	public AuthInfo() {  
		
	}

	public AuthInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public AuthInfo(String email, String name, String password, int age, int gender) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public int getAge() {
		return age;
	}

	public int getGender() {
		return gender;
	}
	
}//end class
