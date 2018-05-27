package com.blood.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.AccountAddressDto;
import com.blood.business.dto.AccountDto;
import com.blood.business.dto.AddressDto;
import com.blood.data.entity.Account;
import com.blood.data.entity.AccountAddress;
import com.blood.data.entity.Address;
import com.blood.data.repository.AccountAddressRepository;
import com.blood.data.repository.AccountRepository;
import com.blood.data.repository.AddressRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository acountRepository;
	@Autowired
	AccountAddressRepository accountAddressRepository;
	@Autowired
	AddressRepository addressRepository;

	public void deleteAccount(int id) {
		Account account = acountRepository.findByAccountId(id);
		acountRepository.delete(account);
	}

	public Account createAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountEmail(accountDto.getAccountEmail());
		account.setAccountType(accountDto.getAccountType());
		account.setDonor(accountDto.getDonor());
		account.setPatient(accountDto.getPatient());
		Account insertedAccount = acountRepository.save(account);
		return insertedAccount;
	}

	public AccountAddress createAccountAddress(AccountAddressDto accountAddressDto) {
		AccountAddress accountAddress = new AccountAddress();
		accountAddress.setAccount(accountAddressDto.getAccount());
		accountAddress.setAccountsAddressesId(accountAddressDto.getAccountsAddressesId());
		accountAddress.setAddress(accountAddressDto.getAddress());
		AccountAddress insertedAccountAddress = accountAddressRepository.save(accountAddress);
		return insertedAccountAddress;
	}

	public Address createAddress(AddressDto addressDto) {
		Address address = new Address();
		address.setAddressName(addressDto.getAddressName());
		Address insertedAddress = addressRepository.save(address);
		return insertedAddress;
	}

	public Address getAddress(String address) {
		return addressRepository.findByAddressName(address);
	}
}
