package edu.abcbank.serviceImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.abcbank.model.Biller;
import edu.abcbank.repository.BillerRepository;
import edu.abcbank.service.BillerService;

@Service
public class BillerServiceImpl implements BillerService {
	@Autowired
	private BillerRepository billerRepository;
	
	@Transactional
	@Override
	public Object insertBiller(Biller biller) {
		Map<String, Object> map = new HashMap<String, Object>();	
	if(biller == null) {
		map.put("status", "error");
		map.put("message", "biller object cannot be null");
	}else if(biller.getBillerName().isEmpty()) {
		map.put("status", "error");
		map.put("message", "biller name cannot be null");
	}else if(biller.getBillerAddress().isEmpty()) {
		map.put("status", "error");
		map.put("message", "biller addresss cannot be null");
	}else if(biller.getCity().isEmpty()) {
		map.put("status", "error");
		map.put("message", "biller city cannot be null");
	}else if(biller.getBillerStatus().isEmpty()) {
		map.put("status", "error");
		map.put("message", "biller status cannot be null");
	}else {
		map.put("status", "success");
		map.put("message", "Biller data saved successfully");
		billerRepository.save(biller);
	}
		
		return map;
	}
	
	@Transactional
	@Override
	public Object  updateBiller(Biller biller) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(biller == null) {
			map.put("status", "error");
			map.put("message", "biller object cannot be null");
		}else if(biller.getBillerName().isEmpty()) {
			map.put("status", "error");
			map.put("message", "biller name cannot be null");
		}else if(biller.getBillerAddress().isEmpty()) {
			map.put("status", "error");
			map.put("message", "biller addresss cannot be null");
		}else if(biller.getCity().isEmpty()) {
			map.put("status", "error");
			map.put("message", "biller city cannot be null");
		}else if(biller.getBillerStatus().isEmpty()) {
			map.put("status", "error");
			map.put("message", "biller status cannot be null");
		}else {
			map.put("status", "success");
			map.put("message", "Biller data updated successfully");
			billerRepository.saveAndFlush(biller);
		}
			
			return map;
		
	}
	
	@Transactional
	public Object getBillerByAccountNumber(BigInteger accountNumber ){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        List<List<Biller>> biller1 = billerRepository.fetchBillerByAccountNumber(accountNumber);

     for(List<Biller> b : biller1) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 for(Biller b1 : b) {
    		 map.put("billerId", b1.getBillerId());
    		 map.put("billerName", b1.getBillerName());
        	 map.put("billerAddress", b1.getBillerAddress());
        	 map.put("city", b1.getCity());
        	 map.put("pinCode", b1.getPinCode());
        	 map.put("billerCategory", b1.getBillerCategory());
        	 map.put("billerStatus", b1.getBillerStatus());
        	 map.put("dueDate", b1.getFixedBillAmount());
        	 list.add(map);	 
    	 } 	 
        
     }
		return list;
		
	}

	@Override
	public Object setFixedBillAmountByBillerId(Biller biller) {
		
		return null;
	}




	

	
}

	

