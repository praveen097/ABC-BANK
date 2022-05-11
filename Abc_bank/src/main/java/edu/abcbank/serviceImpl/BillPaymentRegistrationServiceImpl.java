package edu.abcbank.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.model.Account;
import edu.abcbank.model.BillPaymentRegistration;
import edu.abcbank.repository.BillPaymentRegistrationRepository;
import edu.abcbank.service.BillPaymentRegistrationService;

@Service
public class BillPaymentRegistrationServiceImpl implements BillPaymentRegistrationService{
	@Autowired
	private BillPaymentRegistrationRepository billPaymentRegistrationRepository;

	@Override
	public Object insertAccount(BillPaymentRegistration billPaymentRegistrations) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(billPaymentRegistrations == null) {
			map.put("status", "error");
			map.put("message", "Bill payment registration details can't be null");
		}else if(billPaymentRegistrations.getPreferedAccount1() == null) {
			map.put("status", "error");
			map.put("message", "Preferred account1 cannot be null");
		}else {
			map.put("status", "success");
			map.put("message", "Accounts saved successfully");
			billPaymentRegistrationRepository.save(billPaymentRegistrations);
		}
		return map;
	}



}
