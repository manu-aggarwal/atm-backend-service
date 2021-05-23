package com.bank.repository;

public interface TransactionRepository {

	boolean createTransaction(String accountNumber, double amount, String txnType);

}
