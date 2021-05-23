package com.bank.repository;

import java.util.List;

import com.bank.request.Account;

public interface AccountRepository {

	boolean deposit(String accountNumber, double amount);

	boolean withdraw(String accountNumber, double amount);

	double getBalance(String accountNumber);

	List<Account> getAllAccounts();

	boolean isUserExist(String aadhaar);

	String createUser(Account request);

}
