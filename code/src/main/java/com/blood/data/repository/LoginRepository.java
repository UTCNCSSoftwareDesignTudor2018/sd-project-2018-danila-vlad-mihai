package com.blood.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.data.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	public Login findByLoginUsernameAndLoginPassword(String username, String password);

	public Login findByLoginId(int id);
}
