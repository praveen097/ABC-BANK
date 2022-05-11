package edu.abcbank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.repository.BillerRepository;
import edu.abcbank.service.BillerService;

@Service
public class BillerServiceImpl implements BillerService {
	@Autowired
	private BillerRepository billerRepository;

}
