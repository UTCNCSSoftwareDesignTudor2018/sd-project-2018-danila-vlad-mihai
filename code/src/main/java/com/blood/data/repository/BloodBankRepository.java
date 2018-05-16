package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.BloodBank;


@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Integer>  {

}
