package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.request.Transaction;

@Service
public class TransactionManagementService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public String deposit(Transaction request) {
		if (request.getAmount() > 0) {
			boolean result = accountRepository.deposit(request.getAccountNumber(), request.getAmount());
			if (result) {
				transactionRepository.createTransaction(request.getAccountNumber(), request.getAmount(), "CR");
				return "Money is successfully credited";
			} else {
				return "Money deposit failed";
			}
		} else {
			return "Please enter amount greater than 0";
		}
	}

	@Transactional
	public String withdrawal(Transaction request) {
		double balance = accountRepository.getBalance(request.getAccountNumber());
        if (balance >= request.getAmount()) {
            boolean result = accountRepository.withdraw(request.getAccountNumber(), request.getAmount());
            if (result) {
            	transactionRepository.createTransaction(request.getAccountNumber(), request.getAmount(), "DR");
                return "Money is successfully debited";
            } else {
                return "Money debit failed";
            }
        } else {
            return "Insufficient Balance";
        }
	}

}
