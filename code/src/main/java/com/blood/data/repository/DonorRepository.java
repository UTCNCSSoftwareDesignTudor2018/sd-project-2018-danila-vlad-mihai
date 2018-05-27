package com.blood.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.BloodBank;
import com.blood.data.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	public List<Donor> findAllByBloodBank(BloodBank bloodBank);

	public Donor findByDonorId(int id);

}
