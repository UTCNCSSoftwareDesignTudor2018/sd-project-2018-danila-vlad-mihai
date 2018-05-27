package com.blood.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;

	@Column
	private String patientFirstname;

	@Column
	private String patientLastname;

	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	private List<Account> accounts;

	public Patient() {

	}

	public Patient(int patientId, String patientFirstname, String patientLastname, List<Account> accounts) {
		super();
		this.patientId = patientId;
		this.patientFirstname = patientFirstname;
		this.patientLastname = patientLastname;
		this.accounts = accounts;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstname() {
		return patientFirstname;
	}

	public void setPatientFirstname(String patientFirstname) {
		this.patientFirstname = patientFirstname;
	}

	public String getPatientLastname() {
		return patientLastname;
	}

	public void setPatientLastname(String patientLastname) {
		this.patientLastname = patientLastname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstname=" + patientFirstname + ", patientLastname="
				+ patientLastname + "]";
	}

	public static class PatientBuilder {
		private int patientId;
		private String patientFirstname;
		private String patientLastname;
		private List<Account> accounts;

		public PatientBuilder patientId(Integer patientId) {
			this.patientId = patientId;
			return this;
		}

		public PatientBuilder patientFirstname(String patientFirstname) {
			this.patientFirstname = patientFirstname;
			return this;
		}

		public PatientBuilder patientLastname(String patientLastname) {
			this.patientLastname = patientLastname;
			return this;
		}

		public PatientBuilder patientAccount(List<Account> accounts) {
			this.accounts = accounts;
			return this;
		}

		public Patient build() {
			return new Patient(patientId, patientFirstname, patientLastname, accounts);
		}
	}

}
