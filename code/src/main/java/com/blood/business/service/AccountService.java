package com.blood.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.AccountDto;
import com.blood.data.entity.Account;
import com.blood.data.entity.Login;
import com.blood.data.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository acountRepository;
	
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
}
