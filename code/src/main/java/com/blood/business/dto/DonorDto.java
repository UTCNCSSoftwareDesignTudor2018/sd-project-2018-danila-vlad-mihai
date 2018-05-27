package com.blood.business.dto;

import java.util.List;

import com.blood.data.entity.Account;
import com.blood.data.entity.BloodBank;

public class DonorDto {

	private int donorId;
	private String donorFirstname;
	private String donorLastname;
	private String donorAvailability;
	private BloodBank bloodBank;
	private List<Account> accounts;

	public DonorDto() {

	}

	public DonorDto(String donorFirstname, String donorLastname, String donorAvailability, BloodBank bloodBank) {
		super();
		this.donorFirstname = donorFirstname;
		this.donorLastname = donorLastname;
		this.donorAvailability = donorAvailability;
		this.bloodBank = bloodBank;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorFirstname() {
		return donorFirstname;
	}

	public void setDonorFirstname(String donorFirstname) {
		this.donorFirstname = donorFirstname;
	}

	public String getDonorLastname() {
		return donorLastname;
	}

	public void setDonorLastname(String donorLastname) {
		this.donorLastname = donorLastname;
	}

	public String getDonorAvailability() {
		return donorAvailability;
	}

	public void setDonorAvailability(String donorAvailability) {
		this.donorAvailability = donorAvailability;
	}

	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return donorFirstname + " " + donorLastname + " availability: " + donorAvailability + " bloodType: "
				+ bloodBank.getBloodType() + accounts;
	}

}
