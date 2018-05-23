package com.blood.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts_addresses")
public class AccountAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountsAddressesId;

	@ManyToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;

	public AccountAddress() {

	}

	public AccountAddress(Integer accountsAddressesId, Address address, Account account) {
		super();
		this.accountsAddressesId = accountsAddressesId;
		this.address = address;
		this.account = account;
	}

	public Integer getAccountsAddressesId() {
		return accountsAddressesId;
	}

	public void setAccountsAddressesId(Integer accountsAddressesId) {
		this.accountsAddressesId = accountsAddressesId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "accountsAddressesId: " + accountsAddressesId + ", address: " + address;
	}

}
