package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.member.dao.MemberDAO;
import com.example.security.jwt.JwtAuthenticationFilter;
import com.example.security.jwt.JwtAuthorizationFilter;
import com.example.security.service.CorsConfig;

//환경설정을 하겠다는 의미
@Configuration
@EnableWebSecurity //springSecurityFilterChain에 등록
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	@Autowired
	private MemberDAO userRepository;

	@Autowired
	private CorsConfig corsConfig;

	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filerChain(HttpSecurity http) throws Exception {

		//csrf() : Cross Site Request Forgery로 사이트간 위조 요청으로 정상적인 사용자가 의도치 않은 위조 요청을 보내는 것을 의미한다. 
		http.csrf().disable();

		//API를 사용하므로 기본으로 제공하는 formLogin()페이지를 끄기 
		http.formLogin().disable();

		//httpBasic 방식 대신 JWT를 사용하기 때문에 httpBasic()끄기 
		http.httpBasic().disable();

		//세션끄기 : JWT를 사용하기 때문에 세션을 사용하지 않는다. 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		//인증사용, security Filter에 등록, @CrossOrigin( 인증 x )
		http.apply(new MyCustomerFilter());

		// 요청에 의한 인가(권한)검사 시작
		//http.authorizeHttpRequests()
		//.antMatchers("/", "/images/**", "/login", "/member/signup", "/board/list/**", "/board/view/**", "/board/update/**").permitAll() //로그인 없이 접근 허용
		//.anyRequest().authenticated(); //그 외 모든 요청에 대해서 인증(로그인)이 되어야 허용한다. 

		http.authorizeHttpRequests().antMatchers("/", "/images/**", "/register", "/login","/board/list/**", "/editinfo" ).permitAll() //로그인 없이 접근 허용
		.anyRequest().authenticated(); //그 외 모든 요청에 대해서 인증(로그인)이 되어야 허용한다

		return http.build();
	}


	//내부클래스 !!
	public class MyCustomerFilter extends AbstractHttpConfigurer<MyCustomerFilter, HttpSecurity>{

		@Override
		public void configure(HttpSecurity http) throws Exception {
			AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);

			// @CrossOrigin(인증 x), Security Filter에 등록 (인증 o)
			http.addFilter(corsConfig .corsFilter()); //응답과 관련있는 코드, 없다면 200번 에러 발생함 

			//addFilter() : FilterComparator에 등록되어 있는 Filter들을 활성화할 때 사용 
			//addFilterBefore(),addFilterAfter() : CustomFilter를 등록할 때 사용
			//인증 필터 등록
			http.addFilter(new JwtAuthenticationFilter(authenticationManager))
			//인가(권한) 필터 등록
			.addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository));
		}
	}
}








