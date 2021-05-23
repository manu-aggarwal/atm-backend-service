package com.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.request.Account;
import com.bank.service.AccountManagementService;
import com.bank.service.AuthorizationService;

@RestController
public class AccountMangementController {

	@Autowired
	private AuthorizationService authService;

	@Autowired
	private AccountManagementService accountService;

	@GetMapping(value = "/accounts")
	public Object getAccounts(@RequestHeader(required = true, name = "Authorization") String auth) {
		try {
			if (authService.validateAuth(auth))
				return accountService.getAllAccounts();

			return "Invalid Token";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured while fetching all account";
		}
	}

	@PostMapping(value = "/account")
	public String createAccount(@RequestHeader(required = true, name = "Authorization") String auth,
			@RequestBody @Valid Account request) {
		try {
			if (authService.validateAuth(auth))
				return accountService.createAccount(request);

			return "Invalid Token";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured while fetching all account";
		}
	}

}
