package edu.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.model.Account;
import edu.abcbank.model.Customer;
import edu.abcbank.repository.CustomerRepository;
import edu.abcbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	@Override
	public Object getAccountsOfCustomer(Customer customer) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			List<Account> accounts = customerRepository.getAllAccountsOfCustomer(customer.getCustomerId());
			if(accounts.size()==0) {
				System.out.println(accounts);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("message", "no accounts found with this id");
				list.add(map);
			}else {
				for(Account a : accounts) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("accountNumber", a.getAccountNumber());
					map.put("customerName", a.getCustomer().getFirstName());
					list.add(map);
				}
			}
		return list;
	}

}
