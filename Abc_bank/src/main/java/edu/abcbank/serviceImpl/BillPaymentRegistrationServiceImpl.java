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
			map.put("message", "Please enter bill payment registration details");
		}else {
			System.out.println("Bill id :" + billPaymentRegistrations.getBillPaymentRegId());
			System.out.println("acc1 :" + billPaymentRegistrations.getPreferedAccount1());
			System.out.println("acc2"+billPaymentRegistrations.getPreferedAccount2());
			System.out.println("customerId: " + billPaymentRegistrations.getCustomer());
			map.put("status", "success");
			map.put("message", "Accounts saved successfully");
			billPaymentRegistrationRepository.save(billPaymentRegistrations);
		}
		return map;
	}



}
