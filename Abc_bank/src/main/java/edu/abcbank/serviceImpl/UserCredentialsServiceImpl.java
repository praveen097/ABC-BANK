package edu.abcbank.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.model.UserCredentials;
import edu.abcbank.repository.UserCredentialsRepository;
import edu.abcbank.service.UserCredentialsService;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService{
	
	@Autowired
	private UserCredentialsRepository credentialsRepository;

	@Override
	public Object validateUser(UserCredentials credentials) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(credentials.getUserName().isEmpty() || credentials.getPassword().isEmpty()) {
			map.put("staus", "Error");
			map.put("message", "username or password are empty");
		}else {
			UserCredentials credentials1 = credentialsRepository.validateUser(credentials.getUserName(), credentials.getPassword());
			if(credentials1!=null)
			{
				map.put("status", "success");
				map.put("msg", "User exists");
				map.put("customerid", credentials1.getAccount().getCustomer().getCustomerId());
			}else
			{
				map.put("status", "Error");
				map.put("msg", "User does not exists");			}
			
		}
		return map;
	}

	

}
