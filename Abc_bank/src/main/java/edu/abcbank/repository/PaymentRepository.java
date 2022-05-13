package edu.abcbank.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Account;
import edu.abcbank.model.Biller;
import edu.abcbank.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	@Query("select a from Account a where a.accountNumber=:accountNumber")
	Account getAccountBalanceByAccountNumber(BigInteger accountNumber);
	
	@Query("select b from Biller b where b.account.accountNumber=:accountNumber")
	List<List<Biller>> fetchBillersByAccountNumber(BigInteger accountNumber);

}
