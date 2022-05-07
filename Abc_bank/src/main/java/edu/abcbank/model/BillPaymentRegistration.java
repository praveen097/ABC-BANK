package edu.abcbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abc_billpayment")
public class BillPaymentRegistration 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="billpaymentId")
	private int billPaymentRegId;
	@Column(name="preferedAccount1",nullable=false)
	private int preferedAccount1;
	@Column(name="preferedAccount2",nullable=true)
	private int preferedAxccount2;
	
	
	
	public int getBillPaymentRegId() 
	{
		return billPaymentRegId;
	}
	public void setBillPaymentRegId(int billPaymentRegId) 
	{
		this.billPaymentRegId = billPaymentRegId;
	}
	public int getPreferedAccount1() 
	{
		return preferedAccount1;
	}
	public void setPreferedAccount1(int preferedAccount1) 
	{
		this.preferedAccount1 = preferedAccount1;
	}
	public int getPreferedAxccount2() 
	{
		return preferedAxccount2;
	}
	public void setPreferedAxccount2(int preferedAxccount2) 
	{
		this.preferedAxccount2 = preferedAxccount2;
	}

}
