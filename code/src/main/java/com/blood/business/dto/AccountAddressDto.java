package com.blood.business.dto;

import com.blood.data.entity.Account;
import com.blood.data.entity.Address;

public class AccountAddressDto {
	private Integer accountsAddressesId;
	private Address address;
	private Account account;

	public AccountAddressDto(Address address, Account account) {
		super();
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

}
