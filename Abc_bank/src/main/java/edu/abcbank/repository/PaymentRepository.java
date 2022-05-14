package edu.abcbank.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query("select p from Payment p where p.biller.billerId=:billerId")
	Payment getPaymentByBillerId(@Param("billerId") int billerId);

	@Query("select p from Payment p where p.biller.billerId=:billerId")
	List<List<Payment>> fetchAllPaymentsByBillerId(int billerId);

	@Query("select p from Payment p where p.biller.account.accountNumber=:accountNumber and p.biller.billerCategory=:category")
	List<List<Payment>> fetchAllPaymentsByCategory(@Param("accountNumber") BigInteger accountNumber,@Param("category") String category);

}
