package edu.abcbank.controller;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import edu.abcbank.model.Payment;
import edu.abcbank.service.PaymentService;

@RestController
@CrossOrigin
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
		return (paymentService.getBillersByAccountNumber(accountNumber));
	}
	
	@Transactional
	@RequestMapping(value = "/updateDueDateByBillerId", method = RequestMethod.PUT)
	public Object updateBillerDueDateByBillerId(@RequestBody Payment payment) {
//		return (paymentService.updateBillerDueDate(payment.getBiller().getBillerId(), payment.getDueDate()));
		return (paymentService.fetchPaymentUsingBillerId(payment));
	}
	
	@Transactional
	@RequestMapping(value = "/fetchAllPaymentsByAccountNumber", method = RequestMethod.POST)
	public Object fetchAllPaymentByBillerId(@RequestBody Payment payment) {
		return (paymentService.fetchAllPaymentsByAccountNumber(payment.getBiller().getAccount().getAccountNumber()));
	}

	@Transactional
	@RequestMapping(value = "/fetchAllPaymentsByCategory", method = RequestMethod.POST)
	public Object fetchAllPaymentByCategory(@RequestBody Payment payment) {
		return (paymentService.fetchAllPaymentsByCategory(payment.getBiller().getAccount().getAccountNumber(),payment.getBiller().getBillerCategory()));
	}
	
	@Transactional
	@RequestMapping(value = "/fetchAllPaymentsByCategoryAndStatus", method = RequestMethod.POST)
	public Object fetchAllPaymentByCategoryAndStatus(@RequestBody Payment payment) {
		return (paymentService.fetchAllPaymentsByCategoryAndStatus(payment.getBiller().getAccount().getAccountNumber(),payment.getBiller().getBillerCategory(), payment.getBillPaymentStatus()));
	}
}
