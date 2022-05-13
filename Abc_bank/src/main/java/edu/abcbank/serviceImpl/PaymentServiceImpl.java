package edu.abcbank.serviceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.model.Account;
import edu.abcbank.model.Biller;
import edu.abcbank.model.Payment;
import edu.abcbank.repository.PaymentRepository;
import edu.abcbank.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Transactional
	@Override
	public Object getAccountBalanceUsingAccountNumber(BigInteger accountNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		Account account = paymentRepository.getAccountBalanceByAccountNumber(accountNumber);
		map.put("accountBalance", account.getBalance());
		return map;
	}
	
	@Transactional
	@Override
	public Object makePayment(Payment payment) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(payment.getPaymentDate() == null) {
			map.put("status", "error");
			map.put("message", "payment date cannot be null");
		}else if(payment.getPaymentMadeBy().isEmpty()) {
			map.put("status", "error");
			map.put("message", "payment date cannot be null");
		}else {
			paymentRepository.save(payment);
			map.put("status", "success");
			map.put("message", "payment details updated successfully");
		}
		return map;
	}

	@Override
	public Object getBillersByAccountNumber(BigInteger accountNumber) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        List<List<Biller>> biller1 = paymentRepository.fetchBillersByAccountNumber(accountNumber);

     for(List<Biller> b : biller1) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 for(Biller b1 : b) {
    		 map.put("billerId", b1.getBillerId());
    		 map.put("billerName", b1.getBillerName());
        	 list.add(map);	 
    	 } 	 
        
     }
		return list;
	}
	

}
