package edu.abcbank.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="abc_biller")
public class Biller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="billerId")
	private int billerId;
	@Column(name="billerName", length = 30, nullable = false)
	private String billerName;
	@Column(name="billerAddress", length = 40, nullable = false)
	private String billerAddress;
	@Column(name="city",length = 15, nullable = false)
	private String city;
	@Column(name="pincode", nullable = false)
	private BigInteger pinCode;
	@Column(name="billercategory", length = 15, nullable = false)
	private String billerCategory;
	@Column(name="billerStatus", length = 20, nullable = true)
	private String billerStatus;
	@Column(name="fixedBillAmount", length = 20, nullable = true)
	private BigDecimal fixedBillAmount;
	
	@ManyToOne
	@JoinColumn(name = "account_number",nullable = false)
	private Account account;
	@OneToMany(mappedBy = "biller")
	private List<Payment> payement;
	
	public BigDecimal getFixedBillAmount() {
		return fixedBillAmount;
	}
	public void setFixedBillAmount(BigDecimal fixedBillAmount) {
		this.fixedBillAmount = fixedBillAmount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Payment> getPayement() {
		return payement;
	}
	public void setPayement(List<Payment> payement) {
		this.payement = payement;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBillerCategory() {
		return billerCategory;
	}
	public void setBillerCategory(String billercategory) {
		this.billerCategory = billercategory;
	}
	
	public int getBillerId() {
		return billerId;
	}
	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}
	public String getBillerName() {
		return billerName;
	}
	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}
	public String getBillerAddress() {
		return billerAddress;
	}
	public void setBillerAddress(String billerAddress) {
		this.billerAddress = billerAddress;
	}
	
	public BigInteger getPinCode() {
		return pinCode;
	}
	public void setPinCode(BigInteger pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getBillerStatus() {
		return billerStatus;
	}
	public void setBillerStatus(String billerStatus) {
		this.billerStatus = billerStatus;
	}
	

	
}
