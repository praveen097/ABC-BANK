package edu.abcbank.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Biller;

@Repository
public interface BillerRepository extends JpaRepository<Biller, Integer> {

	@Query("select b from Biller b where b.account.accountNumber=:accountNumber")
	List<List<Biller>> fetchBillerByAccountNumber(@Param("accountNumber") BigInteger accountNumber);
	
//	@Query("update Biller b set b.dueDate=:dueDate where b.billerId=:billerId")
//	void updateBillerDueDateByBillerId(@Param("billerId") BigInteger billerId,@Param("dueDate") Date dueDate);



}
