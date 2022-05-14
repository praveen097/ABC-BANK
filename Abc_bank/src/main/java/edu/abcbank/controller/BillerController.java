package edu.abcbank.controller;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.model.Biller;
import edu.abcbank.service.BillerService;

@RestController
public class BillerController {
	@Autowired
	private BillerService billerService;
	
	@Transactional
	@RequestMapping(value = "/insertBiller", method = RequestMethod.POST)
	public Object insertBiller(@RequestBody Biller biller) {
		return (billerService.insertBiller(biller));
	}
	@Transactional
	@RequestMapping(value = "/updateBiller", method = RequestMethod.POST)
	public Object updateBiller(@RequestBody Biller biller) {
		return (billerService.updateBiller(biller));		
	}
	
	@Transactional
	@RequestMapping(value = "/fetchBillersByAccountNumber/{accountNumber}", method = RequestMethod.GET)
	public Object fetchBillersByAccountNumber(@PathVariable BigInteger accountNumber) {
		return(billerService.getBillerByAccountNumber(accountNumber));
	}

}
