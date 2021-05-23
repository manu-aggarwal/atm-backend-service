package com;

public class DbConstants {

	public static class Query {
		public static final String GET_BALANCE = "SELECT BALANCE FROM ACCOUNT ACC WHERE ACC.ACCOUNT_NUMBER = ?";
		public static final String DEPOSIT = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCOUNT_NUMBER = ?";
		public static final String WITHDRAWAL = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACCOUNT_NUMBER = ?";
		public static final String CREATE_TRANSACTION = "INSERT INTO TRANSACTION (TXN_ID, TXN_TYPE, ACCOUNT_NUMBER, AMOUNT, TRANSACTION_TIME) VALUES (?,?,?,?,?)";
		public static final String GET_ACCOUNTS = "SELECT ACCOUNT_NUMBER, ACCOUNT_HOLDERNAME, PASSWORD, BALANCE, CREATED_ON, STATUS, AADHAAR_NO FROM ACCOUNT ORDER BY CREATED_ON";
		public static final String VERIFY_ACCOUNT = "SELECT COUNT(*) AS ACCOUNT_COUNT FROM ACCOUNT WHERE AADHAAR_NO = ? AND STATUS = ?";
		public static final String CREATE_ACCOUNT = "INSERT INTO ACCOUNT (ACCOUNT_NUMBER, ACCOUNT_HOLDERNAME, PASSWORD, BALANCE, CREATED_ON, STATUS, AADHAAR_NO) VALUES (?,?,?,?,?,?,?)";
	}
}
