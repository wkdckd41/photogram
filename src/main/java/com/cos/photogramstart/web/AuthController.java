package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.Authservice;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final Authservice authservice;
	
//	public AuthController(Authservice authservice) {
//		this.authservice = authservice;
//	}

	@GetMapping("/auth/signin")
	public String signinForm() {
		return"auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return"auth/signup";
	}
	// 회원가입버튼 -> /auth/signup -> /auth/signin
	// 회원가입버튼 X
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupdto) { // key = value (x-www-form-urlencoded)
		log.info(signupdto.toString());
		// User < - SignupDto
		User user = signupdto.toEntity(); 
		User userEntity = authservice.회원가입(user);
		log.info(user.toString());
		System.out.println(userEntity);
		return"auth/signin";
	}
}
 