package edu.abcbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abc_usercredentials")
public class UserCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userCredentialId;
	@Column(length = 25, nullable = false)
	private String userName;
	@Column(length = 25, nullable = false)
	private String password;
//	private Account account;	
	
	public int getUserCredentialId() {
		return userCredentialId;
	}
	public void setUserCredentialId(int userCredentialId) {
		this.userCredentialId = userCredentialId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
