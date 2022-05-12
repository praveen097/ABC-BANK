package edu.abcbank.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="abc_billpayment")
public class BillPaymentRegistration 
{
	@Id
	@Column(name="billpaymentId")
	private int billPaymentRegId;
	@Column(name="preferedAccount1",nullable=false)
	private BigInteger preferedAccount1;
	@Column(name="preferedAccount2",nullable=true)
	private BigInteger preferedAccount2;
	@OneToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;
	
	
	public BigInteger getPreferedAccount1() {
		return preferedAccount1;
	}
	public void setPreferedAccount1(BigInteger preferedAccount1) {
		this.preferedAccount1 = preferedAccount1;
	}
	public BigInteger getPreferedAccount2() {
		return preferedAccount2;
	}
	public void setPreferedAccount2(BigInteger preferedAccount2) {
		this.preferedAccount2 = preferedAccount2;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getBillPaymentRegId() 
	{
		return billPaymentRegId;
	}
	public void setBillPaymentRegId(int billPaymentRegId) 
	{
		this.billPaymentRegId = billPaymentRegId;
	}
	

}
