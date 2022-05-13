package edu.abcbank.service;

import java.math.BigInteger;

import edu.abcbank.model.Payment;

public interface PaymentService {
	public Object getAccountBalanceUsingAccountNumber(BigInteger accountNumber);
	public Object makePayment(Payment payment);
	public Object getBillersByAccountNumber(BigInteger accountNumber);

}
