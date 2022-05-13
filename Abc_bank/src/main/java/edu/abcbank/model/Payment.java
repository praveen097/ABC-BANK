package edu.abcbank.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="abc_payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger paymentId;
	@Column(nullable = true)
	private BigDecimal payingAmount;
	@Column(name="paymentDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	@Column(name="paymentMadeBy", length = 20, nullable = false)
	private String paymentMadeBy;
	@ManyToOne
	@JoinColumn(name = "biller_id", nullable = false)
	private Biller biller;
	
	
//	Getters and setters
	
	public Biller getBiller() {
		return biller;
	}
	public void setBiller(Biller biller) {
		this.biller = biller;
	}
	public BigInteger getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(BigInteger paymentId) {
		this.paymentId = paymentId;
	}
	public BigDecimal getPayingAmount() {
		return payingAmount;
	}
	public void setPayingAmount(BigDecimal payingAmount) {
		this.payingAmount = payingAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMadeBy() {
		return paymentMadeBy;
	}
	public void setPaymentMadeBy(String paymentMadeBy) {
		this.paymentMadeBy = paymentMadeBy;
	}
}