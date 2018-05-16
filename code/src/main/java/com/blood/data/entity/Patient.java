package com.blood.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	 @OneToOne(fetch=FetchType.EAGER)
	 @Fetch(FetchMode.JOIN)
	 @JoinColumn(name="patient_id")
    private Account account;

	
	public Patient(int patientId, String patientFirstname, String patientLastname, Account account) {
		super();
		this.patientId = patientId;
		this.patientFirstname = patientFirstname;
		this.patientLastname = patientLastname;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstname=" + patientFirstname + ", patientLastname="
				+ patientLastname + ", account=" + account + "]";
	}
	public static class PatientBuilder {
		private int patientId;
		private String patientFirstname;
		private String patientLastname;
	    private Account account;

		public PatientBuilder setPatientId(Integer patientId) {
			this.patientId = patientId;
			return this;
		}

		public PatientBuilder setPatientFirstname(String patientFirstname) {
			this.patientFirstname = patientFirstname;
			return this;
		}

		public PatientBuilder setPatientLastname(String patientLastname) {
			this.patientLastname = patientLastname;
			return this;
		}

		public PatientBuilder setPatientAccount(Account account) {
			this.account = account;
			return this;
		}

		public Patient build() {
			return new Patient(patientId, patientFirstname, patientLastname, account);
		}
	}
	
	
}
