package edu.abcbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userCredentials")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userCredentialId")
	private int userCredentialId;
	@Column(name="userName", length = 25, nullable = false)
	private String userName;
	@Column(name="password", length = 15, nullable = false)
	private String password;
	
	
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
