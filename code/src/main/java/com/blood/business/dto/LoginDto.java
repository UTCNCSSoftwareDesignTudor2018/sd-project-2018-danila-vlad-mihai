package com.blood.business.dto;

import com.blood.data.entity.Account;

public class LoginDto {
	
	private int loginId;
	private String loginUsername;
	private String loginPassword;
    private Account account;
    
    public LoginDto() {
    	
    }
    
	public LoginDto(int loginId, String loginUsername, String loginPassword, Account account) {
		super();
		this.loginId = loginId;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.account = account;
	}
	
	public LoginDto(String loginUsername, String loginPassword) {
		super();
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
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
    

}
