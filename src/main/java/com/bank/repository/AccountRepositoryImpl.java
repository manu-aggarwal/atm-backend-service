package com.bank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DbConstants;
import com.bank.request.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public boolean deposit(String accountNumber, double amount) {
		return template.update(DbConstants.Query.DEPOSIT, new Object[] { amount, accountNumber }) == 1;
	}

	@Override
	public boolean withdraw(String accountNumber, double amount) {
		return template.update(DbConstants.Query.WITHDRAWAL, new Object[] { amount, accountNumber }) == 1;
	}

	@Override
	public double getBalance(String accountNumber) {
		return template.queryForObject(DbConstants.Query.GET_BALANCE, new Object[] { accountNumber },
				new RowMapper<Double>() {

					@Override
					public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getDouble("BALANCE");
					}

				});
	}

	@Override
	public List<Account> getAllAccounts() {
		return template.query(DbConstants.Query.GET_ACCOUNTS, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setAccountNumber(rs.getString(1));
				account.setAccountHoldername(rs.getString(2));
				account.setPassword(rs.getString(3));
				account.setBalance(rs.getDouble(4));
				account.setCreatedOn(rs.getString(5));
				account.setStatus(rs.getInt(6));
				account.setAadhaarNumber(rs.getString(7));
				return account;
			}
			
		});
	}

	@Override
	public boolean isUserExist(String aadhaar) {
		return template.queryForObject(DbConstants.Query.VERIFY_ACCOUNT, new Object[] { aadhaar, "1" },
				new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt("ACCOUNT_COUNT");
					}
				}) == 0;
	}

	@Override
	public String createUser(Account request) {
		String accountNumber = request.getAadhaarNumber() + Instant.now().getEpochSecond();
		if (template.update(DbConstants.Query.CREATE_ACCOUNT,
				new Object[] { accountNumber, request.getAccountHoldername(), request.getPassword(), 0,
						LocalDateTime.now(), "1", request.getAadhaarNumber() }) == 1) {
			return accountNumber;
		} else {
			throw new RuntimeException("Unable to create new account at a moment");
		}
	}

}
