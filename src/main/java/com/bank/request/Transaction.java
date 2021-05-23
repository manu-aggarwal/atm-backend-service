package com.bank.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Transaction {
	@NotBlank(message = "Account Number is mandatory")
	private String accountNumber;
	private double amount;
//	private 
}
