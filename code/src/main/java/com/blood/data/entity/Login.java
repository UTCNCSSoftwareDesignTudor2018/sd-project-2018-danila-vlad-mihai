package com.blood.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "logins")
public class Login {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	@Column
	private String loginUsername;
	
	@Column
	private String loginPassword;
	
	 @OneToOne(fetch=FetchType.EAGER)
	 @Fetch(FetchMode.JOIN)
	 @JoinColumn(name="login_id")
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
		return "Login [loginId=" + loginId + ", loginUsername=" + loginUsername + ", loginPassword=" + loginPassword
				+ ", account=" + account + "]";
	}
	
	
}
