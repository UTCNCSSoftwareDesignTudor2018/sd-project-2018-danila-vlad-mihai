package com.blood.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.DonorDto;
import com.blood.business.dto.LoginDto;
import com.blood.business.dto.PatientDto;
import com.blood.data.entity.Donor;
import com.blood.data.entity.Login;
import com.blood.data.entity.Patient;
import com.blood.data.repository.DonorRepository;
import com.blood.data.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	DonorRepository donorRepository;

	public PatientDto findPatientById(int id) {
		PatientDto patientDto = new PatientDto();
		patientDto.setPatientId(patientRepository.findByPatientId(id).getPatientId());
		patientDto.setPatientFirstname(patientRepository.findByPatientId(id).getPatientFirstname());
		patientDto.setPatientLastname(patientRepository.findByPatientId(id).getPatientLastname());
		patientDto.setAccounts(patientRepository.findByPatientId(id).getAccounts());
		return patientDto;
	}

	public List<DonorDto> getDonors() {

		List<DonorDto> donorDtoList = new ArrayList<>();
		List<Donor> donorList = donorRepository.findAll();
		for (Donor d : donorList) {
			DonorDto donorDto = new DonorDto();
			donorDto.setDonorFirstname(d.getDonorFirstname());
			donorDto.setDonorLastname(d.getDonorLastname());
			donorDto.setDonorId(d.getDonorId());
			donorDto.setDonorAvailability(d.getDonorAvailability());
			donorDto.setBloodBank(d.getBloodBank());
			donorDto.setAccounts(d.getAccounts());
			donorDtoList.add(donorDto);
		}
		return donorDtoList;
	}

	public Patient createPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setPatientFirstname(patientDto.getPatientFirstname());
		patient.setPatientLastname(patientDto.getPatientLastname());
		Patient insertedPatient = patientRepository.save(patient);
		return insertedPatient;
	}

	public void deletePatient(int id) {
		Patient patient = patientRepository.findByPatientId(id);
		patientRepository.delete(patient);
	}

}
