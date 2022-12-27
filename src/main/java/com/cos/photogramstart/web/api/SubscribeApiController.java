package com.cos.photogramstart.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@RestController
public class SubscribeApiController {

	@PostMapping("/api/subscribe/{toUserId")
	public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int id) {
		return null;
	}

@DeleteMapping("/api/subscribe/{toUserId")
	public ResponseEntity<?> unsubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int id) {
		return null;
}
}
