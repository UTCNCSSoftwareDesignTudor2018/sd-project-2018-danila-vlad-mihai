package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	public Address findByAddressName(String name);
}
