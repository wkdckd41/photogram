package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.Subscribe.Subscribe;
import com.cos.photogramstart.domain.Subscribe.SubscribeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {
	
	private final SubscribeRepository subscribeRepository ;
	
	@Transactional
	public void 구독하기(int fromUserId, int toUserID) {
		subscribeRepository.mSubscribe(fromUserId, toUserID);
	}

	@Transactional
	public void 구독취소하기(int fromUserId, int toUserID) {
		subscribeRepository.mUnSubscribe(fromUserId, toUserID);

	}	
}
