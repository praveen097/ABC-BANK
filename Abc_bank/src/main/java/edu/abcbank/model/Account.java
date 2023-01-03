package edu.abcbank.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "abc_account")
public class Account {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger accountNumber;
	@Column(nullable = false)
	private BigDecimal balance;
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
	@OneToMany(mappedBy = "account")
	private List<Biller> biller;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public List<Biller> getBiller() {
		return biller;
	}
	public void setBiller(List<Biller> biller) {
		this.biller = biller;
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
