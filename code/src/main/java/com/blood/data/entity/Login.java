package com.blood.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "logins")
public class Login {
	
	
	  @Id
	    @GeneratedValue(generator = "foreigngen")
	    @GenericGenerator(strategy = "foreign", name="foreigngen",
	            parameters = @Parameter(name = "property", value="account"))
	  @Column(name = "login_id")
	private int loginId;
	
	@Column
	private String loginUsername;
	
	@Column
	private String loginPassword;
	@OneToOne(optional=false, mappedBy="login",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Account account;
	public Login() {
		
	}
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "loginId: " + loginId + ", loginUsername: " + loginUsername + ", loginPassword: " + loginPassword;
	}
	
	
}
