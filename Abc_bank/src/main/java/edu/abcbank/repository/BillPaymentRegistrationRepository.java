package edu.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.BillPaymentRegistration;

@Repository
public interface BillPaymentRegistrationRepository extends JpaRepository<BillPaymentRegistration, Integer> {

}
