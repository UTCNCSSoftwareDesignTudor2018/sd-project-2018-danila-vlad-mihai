package com.blood.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column
	private String accountType;
	
	@Column
	private String accountEmail;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "accounts_addresses", joinColumns = { @JoinColumn(name = "accountId") }, inverseJoinColumns = {
			@JoinColumn(name = "addressId") })
	List<Address> addresses;
	
	public Account() {
		
	}
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	

}
