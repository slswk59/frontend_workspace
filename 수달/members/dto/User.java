package com.example.shop.members.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor  //인자값 없는 생성자
@AllArgsConstructor //인자값 있는 생성자
public class User {
	
	private String memberEmail;
	private String memberPass;
	
}
