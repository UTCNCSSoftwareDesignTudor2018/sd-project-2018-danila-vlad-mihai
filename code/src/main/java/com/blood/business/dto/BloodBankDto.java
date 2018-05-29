package com.blood.business.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.blood.data.entity.Donor;

public class BloodBankDto {
	private int bloodId;
	private String bloodType;
	private List<Donor> donors;
	
	public int getBloodId() {
		return bloodId;
	}
	public void setBloodId(int bloodId) {
		this.bloodId = bloodId;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public List<Donor> getDonors() {
		return donors;
	}
	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}
	
	
}
