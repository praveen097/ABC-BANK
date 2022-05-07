package edu.abcbank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="abc_payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	@Column(nullable = true)
	private double payingAmount;
	@Column(name="paymentDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	@Column(name="paymentMadeBy", length = 20, nullable = false)
	private String paymentMadeBy;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getPayingAmount() {
		return payingAmount;
	}
	public void setPayingAmount(double payingAmount) {
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