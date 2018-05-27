package com.blood.business.dto;

import java.util.List;

import com.blood.data.entity.Address;
import com.blood.data.entity.Donor;
import com.blood.data.entity.Login;
import com.blood.data.entity.Patient;

public class AccountDto {
	private int accountId;
	private String accountType;
	private String accountEmail;
	List<Address> addresses;
	private Patient patient;
	private Login login;
	private Donor donor;

	public AccountDto(Login login, String accountEmail) {
		super();
		this.login = login;
		this.accountEmail = accountEmail;
	}

	public AccountDto(String accountType, String accountEmail, Patient patient) {
		super();
		this.accountType = accountType;
		this.accountEmail = accountEmail;
		this.patient = patient;
	}

	public AccountDto(String accountType, String accountEmail, Donor donor) {
		super();
		this.accountType = accountType;
		this.accountEmail = accountEmail;
		this.donor = donor;
	}

	public AccountDto(String accountType, String accountEmail, List<Address> addresses, Patient patient, Login login,
			Donor donor) {
		super();
		this.accountType = accountType;
		this.accountEmail = accountEmail;
		this.addresses = addresses;
		this.patient = patient;
		this.login = login;
		this.donor = donor;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountType=" + accountType + ", accountEmail=" + accountEmail
				+ ", patient=" + patient + ", donor=" + donor + "]";
	}

}
