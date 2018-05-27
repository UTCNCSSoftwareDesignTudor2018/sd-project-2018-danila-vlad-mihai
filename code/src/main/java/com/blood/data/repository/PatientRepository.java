package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Patient findByPatientId(int id);

}
