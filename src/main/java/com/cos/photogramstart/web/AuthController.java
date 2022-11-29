package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.Authservice;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {
	
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
	public  String signup(@Valid SignupDto signupdto, BindingResult bindingResult) { // key = value (x-www-form-urlencoded)
		
		if(bindingResult.hasErrors()) {
			Map<String,String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(),error.getDefaultMessage());
				System.out.println(error.getDefaultMessage());
			}
			throw new CustomValidationException("유효성검사 실패함", errorMap);
		}else {
			// User < - SignupDto
			User user = signupdto.toEntity(); 
			User userEntity = authservice.회원가입(user);
			System.out.println(userEntity);
			return"auth/signin";
		}
	}
}
 