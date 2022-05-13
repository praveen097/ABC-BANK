package edu.abcbank.controller;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.model.Payment;
import edu.abcbank.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@Transactional
	@RequestMapping(value = "/getAccountBalance/{accountNumber}", method = RequestMethod.GET)
	public Object getAccountBalanceUsingAccountNumber(@PathVariable BigInteger accountNumber) {
		return (paymentService.getAccountBalanceUsingAccountNumber(accountNumber));
	}
	
	@Transactional
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public Object makePayment(@RequestBody Payment payment) {
		return (paymentService.makePayment(payment));
	}
	@Transactional
	@RequestMapping(value = "/fetchAllBillersByAccountNumber/{accountNumber}", method = RequestMethod.GET)
	public Object fetchBillersByAccountNumber(@PathVariable BigInteger accountNumber) {
		return(paymentService.getBillersByAccountNumber(accountNumber));
	}

}
