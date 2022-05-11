package edu.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.abcbank.service.BillerService;

@RestController
public class BillerController {
	@Autowired
	private BillerService billerService;
}
