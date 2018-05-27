package com.blood.business.dto;

import java.util.List;

import com.blood.data.entity.Account;

public class AddressDto {
	private int addressId;
	private String addressName;
	private List<Account> accounts;

	public AddressDto(String addressName) {
		super();
		this.addressName = addressName;
	}

	public AddressDto(int addressId, String addressName, List<Account> accounts) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.accounts = accounts;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
