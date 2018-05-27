package com.blood.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.PatientDto;
import com.blood.data.entity.Patient;
import com.blood.data.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public PatientDto findPatientById(int id) {
		PatientDto patientDto = new PatientDto();
		patientDto.setPatientId(patientRepository.findByPatientId(id).getPatientId());
		patientDto.setPatientFirstname(patientRepository.findByPatientId(id).getPatientFirstname());
		patientDto.setPatientLastname(patientRepository.findByPatientId(id).getPatientLastname());
		patientDto.setAccounts(patientRepository.findByPatientId(id).getAccounts());
		return patientDto;
	}

	public Patient createPatient(PatientDto patientDto) {
		Patient patient = new Patient.PatientBuilder().patientFirstname(patientDto.getPatientFirstname())
				.patientLastname(patientDto.getPatientLastname()).build();

		Patient insertedPatient = patientRepository.save(patient);
		return insertedPatient;
	}

	public void deletePatient(int id) {
		Patient patient = patientRepository.findByPatientId(id);
		patientRepository.delete(patient);
	}

	public List<PatientDto> getPatients() {

		List<PatientDto> patientDtoList = new ArrayList<>();
		List<Patient> patientList = patientRepository.findAll();
		for (Patient p : patientList) {
			PatientDto patientDto = new PatientDto();
			patientDto.setPatientFirstname(p.getPatientFirstname());
			patientDto.setPatientLastname(p.getPatientLastname());
			patientDto.setPatientId(p.getPatientId());
			patientDto.setAccounts(p.getAccounts());
			patientDtoList.add(patientDto);
		}
		return patientDtoList;
	}
}
