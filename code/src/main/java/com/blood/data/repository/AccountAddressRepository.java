package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.AccountAddress;

@Repository
public interface AccountAddressRepository extends JpaRepository<AccountAddress, Integer>{
	
}
