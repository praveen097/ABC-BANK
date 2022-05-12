package edu.abcbank.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.model.BillPaymentRegistration;
import edu.abcbank.service.BillPaymentRegistrationService;

@RestController
public class BillPaymentRegistrationController {
	@Autowired
	private BillPaymentRegistrationService billPaymentRegistrationService;
	
	@Transactional
	@RequestMapping(value = "/insertAccounts", method = RequestMethod.POST)
	public Object insertAccounts(@RequestBody BillPaymentRegistration billPaymentRegistration) {
		return (billPaymentRegistrationService.insertAccount(billPaymentRegistration));
	}

}
