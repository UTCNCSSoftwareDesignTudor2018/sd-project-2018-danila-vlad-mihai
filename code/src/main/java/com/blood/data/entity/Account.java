package com.blood.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "accounts_addresses", joinColumns = { @JoinColumn(name = "accountId") }, inverseJoinColumns = {
			@JoinColumn(name = "addressId") })
	List<Address> addresses;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	// @Fetch(FetchMode.JOIN)
	// @JoinColumn(name = "account_id")
	private Login login;

	@ManyToOne
	@JoinColumn(name = "donor_id")
	private Donor donor;

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
		return "type: " + accountType + ", email:" + accountEmail + " " + addresses;
	}

}
