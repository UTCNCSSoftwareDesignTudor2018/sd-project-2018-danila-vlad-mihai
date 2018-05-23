package com.blood.business.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.blood.data.entity.Account;

@Component
public class PatientDto {

	private int patientId;
	private String patientFirstname;
	private String patientLastname;
	private List<Account> accounts;

	public PatientDto() {

	}

	public PatientDto(int patientId, String patientFirstname, String patientLastname, List<Account> accounts) {
		super();
		this.patientId = patientId;
		this.patientFirstname = patientFirstname;
		this.patientLastname = patientLastname;
		this.accounts = accounts;
	}

	public PatientDto(String patientFirstname, String patientLastname) {
		super();
		this.patientFirstname = patientFirstname;
		this.patientLastname = patientLastname;
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

}
