package com.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.request.Transaction;
import com.bank.service.AuthorizationService;
import com.bank.service.TransactionManagementService;

@RestController
public class TransactionManagementController {

	@Autowired
	private AuthorizationService authService;

	@Autowired
	private TransactionManagementService transactionService;

	@PostMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deposit(@RequestHeader(required = true, name = "Authorization") String auth,
			@RequestBody @Valid Transaction request) {
		try {
			if (authService.validateAuth(auth))
				return transactionService.deposit(request);

			return "Invalid Token";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured while fetching all account";
		}
	}
	
	@PostMapping(value = "/withdrawal", produces = MediaType.APPLICATION_JSON_VALUE)
	public String withdrawal(@RequestHeader(required = true, name = "Authorization") String auth,
			@RequestBody @Valid Transaction request) {
		try {
			if (authService.validateAuth(auth))
				return transactionService.withdrawal(request);

			return "Invalid Token";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured while fetching all account";
		}
	}

}
