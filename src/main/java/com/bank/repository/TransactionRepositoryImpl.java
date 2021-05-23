package com.bank.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DbConstants;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Autowired
	private JdbcTemplate template;
	
	Random r = new Random();

	@Override
	public boolean createTransaction(String accountNumber, double amount, String txnType) {
		String txnId = accountNumber + r.nextInt(9999) + Instant.now().getEpochSecond();
		return template.update(DbConstants.Query.CREATE_TRANSACTION,
				new Object[] { txnId, txnType, accountNumber, amount, LocalDateTime.now() }) == 1;
	}

}
