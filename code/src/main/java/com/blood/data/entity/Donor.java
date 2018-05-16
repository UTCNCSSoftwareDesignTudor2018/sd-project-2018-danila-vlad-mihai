package com.blood.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "donors")
public class Donor {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donorId;
	
	@Column
	private String donorFirstname;
	
	@Column
	private String donorLastname;
	
	@Column
	private String donorAvailability;
	
	@ManyToOne
	@JoinColumn(name = "bloodbank_id")
	private BloodBank bloodBank;

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "donor_id")
    private Account account;
	
	public Donor() {
	}

	public Donor(int donorId, String donorFirstname, String donorLastname, String donorAvailability,
			BloodBank bloodBank, Account account) {
		super();
		this.donorId = donorId;
		this.donorFirstname = donorFirstname;
		this.donorLastname = donorLastname;
		this.donorAvailability = donorAvailability;
		this.bloodBank = bloodBank;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorFirstname=" + donorFirstname + ", donorLastname=" + donorLastname
				+ ", donorAvailability=" + donorAvailability + ", bloodBank=" + bloodBank + ", account=" + account
				+ "]";
	}



	public static class DonorBuilder {
		private int donorId;
		private String donorFirstname;
		private String donorLastname;
		private String donorAvailability;
		private BloodBank bloodBank;
		private Account account;

		public DonorBuilder setDonorId(Integer donorId) {
			this.donorId = donorId;
			return this;
		}

		public DonorBuilder setDonorFirstname(String donorFirstname) {
			this.donorFirstname = donorFirstname;
			return this;
		}

		public DonorBuilder setDonorLastname(String donorLastname) {
			this.donorLastname = donorLastname;
			return this;
		}

		public DonorBuilder setDonorAvailability(String donorAvailability) {
			this.donorAvailability = donorAvailability;
			return this;
		}

		public DonorBuilder setDonorBloodBank(BloodBank bloodBank) {
			this.bloodBank = bloodBank;
			return this;
		}
		public DonorBuilder setDonorAccount(Account account) {
			this.account = account;
			return this;
		}

		public Donor build() {
			return new Donor(donorId, donorFirstname, donorLastname, donorAvailability, bloodBank, account);
		}
	}

}
