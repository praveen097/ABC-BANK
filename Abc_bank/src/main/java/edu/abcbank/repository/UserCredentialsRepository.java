package edu.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.abcbank.model.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer> {
	
	@Query("select u from UserCredentials u where u.userName=:userName and u.password=:password")
	UserCredentials validateUser(@Param("userName") String userName, @Param("password") String password);

}
