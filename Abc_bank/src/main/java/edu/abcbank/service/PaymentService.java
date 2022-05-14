package edu.abcbank.service;

import java.math.BigInteger;
import java.util.Date;

import edu.abcbank.model.Payment;

public interface PaymentService {
	public Object getAccountBalanceUsingAccountNumber(BigInteger accountNumber);
	public Object makePayment(Payment payment);
	public Object getBillersByAccountNumber(BigInteger accountNumber);
	public Object updateBillerDueDate(int billerId, Date dueDate);
	public Object fetchAllPaymentsByBillerId(int billerId);
	public Object fetchAllPaymentsByCategory(BigInteger accountNumber, String category);
//	public Object fetchAllPaymentsByCategory(BigInteger accountNumber, String category, String status);

}
