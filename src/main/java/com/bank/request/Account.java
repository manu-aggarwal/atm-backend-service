package com.bank.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Account {
	@NotBlank(message = "Account Number is mandatory")
	private String accountNumber;
	@NotBlank(message = "Account holder name is mandatory")
	private String accountHoldername;
	@NotBlank(message = "Password is mandatory")
	private String password;
	private double balance;
	private String createdOn;
	private int status;
	@NotBlank(message = "Aadhaar Number is mandatory")
	private String aadhaarNumber;
}
