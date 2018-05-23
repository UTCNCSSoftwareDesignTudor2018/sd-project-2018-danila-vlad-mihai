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
@Table(name = "blood_banks")
public class BloodBank {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bloodId;
	@Column
	private String bloodType;
	@OneToMany(mappedBy = "bloodBank", fetch = FetchType.EAGER)
	private List<Donor> donors;

	public BloodBank() {

	}

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

	@Override
	public String toString() {
		return "BloodBank [bloodId=" + bloodId + ", bloodType=" + bloodType + ", donors=" + donors + "]";
	}

}
