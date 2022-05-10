package edu.abcbank.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.model.Customer;
import edu.abcbank.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Transactional
	@RequestMapping(value="/getAccountsOfCustomer", method = RequestMethod.POST)
	public Object getAccountsOfCustomer(@RequestBody Customer customer)	{
		return (customerService.getAccountsOfCustomer(customer));
		
	}

}
