package edu.abcbank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abc_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;
	@Column(nullable = false)
	private double balance;
	@Column(length = 25, nullable = false)
	private String accountType;
	@Column(length = 25, nullable = false)
	private String bankName;
	@Column(length = 25, nullable = false)
	private String branchName;
	@Column(length = 15, nullable = false)
	private String ifscCode;
	@Column(length = 25, nullable = false)
	private String location;
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "userCredentialId", nullable = false)
	private UserCredentials userCredentials;
	@OneToMany(mappedBy = "account")
	private List<Biller> biller;
	
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
