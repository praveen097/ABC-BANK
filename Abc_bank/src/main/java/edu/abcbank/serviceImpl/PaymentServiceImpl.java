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
  		 map.put("billerId", b1.getBiller().getBillerId());

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
	  		 map.put("billerId", b1.getBiller().getBillerId());
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
	  		 map.put("billerId", b1.getBiller().getBillerId());
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
			payment2.setDueDate(payment.getDueDate());
			payment2.setDueDate(payment.getDueDate());
			paymentRepository.saveAndFlush(payment2);
		}else {
			map.put("status", "error");
			map.put("message", "Payment id or biller id are wrong");
		}
		return map;
	}

	@Transactional
	@Override
	public Object deletePaymentUsingPaymentId(BigInteger id) {		
		Payment payment=paymentRepository.findById(id).orElse(null);
		System.out.println(payment);
		Map<String, Object> map = new HashMap<String, Object>();
		if(payment.getPaymentId().ZERO != null) {
			paymentRepository.delete(payment);
			map.put("status", "success");
			map.put("message", "deleted payment successfully");
		 }else {
			 map.put("status", "error");
			 map.put("message", "failed to delete the record");
		 }
		return map;
	}


	@Override
	public Object fetchAllPaymentsByCategoryAndStatusAndDate(BigInteger accountNumber, String category, String status,
			Date fromDate, Date toDate) {
		System.out.println(accountNumber);
		System.out.println(category);
		System.out.println(status);
		System.out.println(toDate);
		System.out.println(fromDate);

		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	      List<List<Payment>> payment1 = paymentRepository.fetchAllPaymentsByCategoryAndStatusAndDate(accountNumber, category,status,fromDate,toDate);
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
	  		 map.put("billerId", b1.getBiller().getBillerId());
	      	 list.add(map);	 
	  	 } 	 

	   }
	return list;
	}

	@Override
	public Object updateBillerDueDate(int billerId, Date dueDate) {
		// TODO Auto-generated method stub
		return null;
	}
}