package com.bank.service;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

	public boolean validateAuth(String authorization) {
		
		String auth = null;
		if (authorization != null && !authorization.isEmpty() && authorization.toLowerCase().contains("bearer ")) {
			auth = authorization.substring(7);
		}
		return "27f685a5-19bd-4522-8d1b-acbc5ea9ca32".equals(auth);
	}

}
