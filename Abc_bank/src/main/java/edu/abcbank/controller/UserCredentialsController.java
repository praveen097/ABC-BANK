package edu.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.model.UserCredentials;
import edu.abcbank.service.UserCredentialsService;

@RestController
@CrossOrigin
public class UserCredentialsController {
	@Autowired
	private UserCredentialsService credentialsService;
	
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public Object getAccountNumber(@RequestBody UserCredentials credentials) {
		return credentialsService.validateUser(credentials);
		
	}
}
