package com.blood.blood;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blood.business.service.AccountService;
import com.blood.data.entity.Account;
import com.blood.data.entity.Address;
import com.blood.data.entity.Login;
import com.blood.data.repository.AccountRepository;
import com.blood.data.repository.AddressRepository;
import com.blood.data.repository.LoginRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloodApplicationTests {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	AccountService accountService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void accountPersistenceTest() {
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setAddressName("Test location");
		addressRepository.save(address);
		addresses.add(address);
		Account account = new Account();
		account.setAccountEmail("test_email@gmail.com");
		account.setAccountType("patient");
		account.setAddresses(addresses);
		
		accountRepository.save(account);
	}
	
	@Test
	public void loginPersistenceTest() {
		Login login = new Login();
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setAddressName("location testing");
		addressRepository.save(address);
		addresses.add(address);
		Account account = new Account();
		account.setAccountEmail("test_email@gmail.com");
		account.setAccountType("patient");
		account.setAddresses(addresses);
		login.setAccount(account);
		login.setLoginPassword("passwordTest");
		login.setLoginUsername("usernameTest");
		
		loginRepository.save(login);
		
	}

}
