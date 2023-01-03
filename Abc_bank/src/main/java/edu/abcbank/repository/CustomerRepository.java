package edu.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Account;
import edu.abcbank.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select a from Account a where a.customer.customerId=:customerId")
	List<Account> getAllAccountsOfCustomer(@Param("customerId") int customerId);
	

}