package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.Account;

@Repository
public interface LoginRepository extends JpaRepository<Account, Integer>{

}
