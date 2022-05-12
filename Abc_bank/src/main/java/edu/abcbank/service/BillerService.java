package edu.abcbank.service;

import java.math.BigInteger;

import edu.abcbank.model.Biller;

public interface BillerService {
	public Object insertBiller(Biller biller);
	public Object updateBiller(Biller biller);
	public Object getBillerByAccountNumber(BigInteger accountNumber);
}
