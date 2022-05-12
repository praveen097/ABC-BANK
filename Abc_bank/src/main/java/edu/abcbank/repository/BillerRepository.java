package edu.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.Biller;

@Repository
public interface BillerRepository extends JpaRepository<Biller, Integer> {

}
