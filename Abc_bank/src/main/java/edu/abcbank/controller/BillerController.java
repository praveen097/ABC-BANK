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

import edu.abcbank.model.Biller;
import edu.abcbank.service.BillerService;

@RestController
@CrossOrigin
public class BillerController {
	@Autowired
	private BillerService billerService;
	
	@Transactional
	@RequestMapping(value = "/insertBiller", method = RequestMethod.POST)
	public Object insertBiller(@RequestBody Biller biller) {
		return (billerService.insertBiller(biller));
	}
	@Transactional
	@RequestMapping(value = "/updateBiller", method = RequestMethod.PUT)
	public Object updateBiller(@RequestBody Biller biller) {
		return (billerService.updateBiller(biller));		
	}
	
	@Transactional
	@RequestMapping(value = "/fetchBillersByAccountNumber/{accountNumber}", method = RequestMethod.GET)
	public Object fetchBillersByAccountNumber(@PathVariable BigInteger accountNumber) {
		return(billerService.getBillerByAccountNumber(accountNumber));
	}
	
	@Transactional
	@RequestMapping(value = "/getBillerById/{id}", method = RequestMethod.GET)
	public Object getBillerByid(@PathVariable int id) {
		return(billerService.getBillerById(id));
	}
	

}
