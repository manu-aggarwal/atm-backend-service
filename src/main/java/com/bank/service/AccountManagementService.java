package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.repository.AccountRepository;
import com.bank.request.Account;

@Service
public class AccountManagementService {

	@Autowired
	private AccountRepository accountRepository;

	public Object getAllAccounts() {
		return accountRepository.getAllAccounts();
	}

	@Transactional
	public String createAccount(Account request) {
		boolean result = accountRepository.isUserExist(request.getAadhaarNumber());
		if (result) {
			String accountNo = accountRepository.createUser(request);
			return "Account created successfully: " + accountNo;
		} else {
			return "User already exist";
		}
	}

}
