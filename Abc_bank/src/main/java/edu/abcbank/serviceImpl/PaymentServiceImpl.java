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
		}else {
			paymentRepository.save(payment);
			map.put("status", "success");
			map.put("message", "payment details updated successfully");
		}
		return map;
	}

	@Transactional
	@Override
	public Object getBillersByAccountNumber(BigInteger accountNumber) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        List<List<Biller>> biller1 = paymentRepository.fetchBillersByAccountNumber(accountNumber);

     for(List<Biller> b : biller1) {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 for(Biller b1 : b) {
    		 map.put("billerId", b1.getBillerId());
    		 map.put("billerName", b1.getBillerName());
    		 map.put("fixedAmount", b1.getFixedBillAmount());
        	 list.add(map);	 
    	 } 	 
        
     }
		return list;
	}

	@Transactional
	@Override
	public Object updateBillerDueDate(int billerId, Date dueDate) {
		Map<String, Object> map = new HashMap<String, Object>();
//		if(billerId == 0) {
//			System.out.println("inside if");
//			map.put("status", "error");
//	 		map.put("message", "due date cannot be null");
//		}else {
		System.out.println(".............");
//		Payment payment = paymentRepository.getPaymentByBillerId(billerId);
//		Biller biller = paymentRepository.getBillerDetailsByBillerId(billerId);
//			Payment payment = paymentRepository.getPaymentByBillerId(billerId);
//			System.out.println("inside else" + biller);

//			if(payment != null) {
//				map.put("status", "success");
//				payment.setDueDate(dueDate);
//				paymentRepository.saveAndFlush(payment);
//			}else {
//				map.put("status", "error");
//		 		map.put("message", "no biller found with this biller id");
//			}
//		}
		
		return map;
	}

	@Override
	public Object fetchAllPaymentsByAccountNumber(BigInteger accountNumber) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
      List<List<Payment>> payment1 = paymentRepository.fetchAllPaymentsByAccountNumber(accountNumber);

   for(List<Payment> b : payment1) {
  	 Map<String, Object> map = new HashMap<String, Object>();
  	 for(Payment b1 : b) {
  		 map.put("paymentId", b1.getPaymentId());
  		 map.put("Amount", b1.getBillAmount());
  		 map.put("paymentDate", b1.getPaymentDate());
  		 map.put("accountNumber", b1.getBiller().getAccount().getAccountNumber());
  		 map.put("billerName", b1.getBiller().getBillerName());
  		 map.put("category", b1.getBiller().getBillerCategory());
  		 map.put("status", b1.getBillPaymentStatus());

      	 list.add(map);	 
  	 } 	 
      
   }
		return list;
	}

	@Override
	public Object fetchAllPaymentsByCategory(BigInteger accountNumber,  String category) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      List<List<Payment>> payment1 = paymentRepository.fetchAllPaymentsByCategory(accountNumber, category);
	   for(List<Payment> b : payment1) {
	  	 Map<String, Object> map = new HashMap<String, Object>();
	  	 for(Payment b1 : b) {
	  		 map.put("paymentId", b1.getPaymentId());
	  		 map.put("Amount", b1.getBillAmount());
	  		 map.put("paymentDate", b1.getPaymentDate());
	  		 map.put("accountNumber", b1.getBiller().getAccount().getAccountNumber());
	  		 map.put("billerName", b1.getBiller().getBillerName());
	  		 map.put("category", b1.getBiller().getBillerCategory());
	  		 map.put("status", b1.getBillPaymentStatus());

	      	 list.add(map);	 
	  	 } 	 

	   }
	return list;
	}

	@Override
	public Object fetchAllPaymentsByCategoryAndStatus(BigInteger accountNumber, String category, String status) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      List<List<Payment>> payment1 = paymentRepository.fetchAllPaymentsByCategoryAndStatus(accountNumber, category,status);
	      System.out.println("............");
	      System.out.println(payment1);
	      if(payment1.isEmpty()) {
	 	  	 Map<String, Object> map = new HashMap<String, Object>();
	 	  	 map.put("status", "error");
	 	  	 map.put("message", "no data found with this account number or category or status");
	 	  	 return map;
	      }
	   for(List<Payment> b : payment1) {
	  	 Map<String, Object> map = new HashMap<String, Object>();
	  	 for(Payment b1 : b) {
	  		 map.put("paymentId", b1.getPaymentId());
	  		 map.put("Amount", b1.getBillAmount());
	  		 map.put("paymentDate", b1.getPaymentDate());
	  		 map.put("accountNumber", b1.getBiller().getAccount().getAccountNumber());
	  		 map.put("billerName", b1.getBiller().getBillerName());
	  		 map.put("category", b1.getBiller().getBillerCategory());
	  		 map.put("status", b1.getBillPaymentStatus());

	      	 list.add(map);	 
	  	 } 	 

	   }
	return list;

}

	@Override
	public Object fetchPaymentUsingBillerId(Payment payment) {
		Map<String, Object> map = new HashMap<String, Object>();
		Payment payment2 = paymentRepository.fetchPaymentByBillerId(payment.getBiller().getBillerId(),payment.getPaymentId());
		if(payment2 != null) {
			map.put("status", "success");
			System.out.println("..........."+payment.getDueDate());
			payment2.setDueDate(payment.getDueDate());
			paymentRepository.saveAndFlush(payment2);
			System.out.println("............");

		}
		return map;
	}
}