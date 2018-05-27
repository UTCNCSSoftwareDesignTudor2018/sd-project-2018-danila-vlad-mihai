package com.blood.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.business.dto.LoginDto;
import com.blood.data.entity.Login;
import com.blood.data.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public LoginDto getLogin(String username, String password) {
		LoginDto loginDto = new LoginDto();
		loginDto.setLoginId(loginRepository.findByLoginUsernameAndLoginPassword(username, password).getLoginId());
		loginDto.setLoginPassword(
				loginRepository.findByLoginUsernameAndLoginPassword(username, password).getLoginPassword());
		loginDto.setLoginUsername(
				loginRepository.findByLoginUsernameAndLoginPassword(username, password).getLoginUsername());
		loginDto.setAccount(loginRepository.findByLoginUsernameAndLoginPassword(username, password).getAccount());
		return loginDto;
	}

	public void updateLoginPassword(int id, String password) {
		Login login = loginRepository.findByLoginId(id);
		login.setLoginPassword(password);
		System.out.println(login);
		loginRepository.save(login);
	}

	public void deleteLogin(int id) {
		Login login = loginRepository.findByLoginId(id);
		loginRepository.delete(login);
	}

	public void createLogin(LoginDto loginDto) {
		Login login = new Login();
		login.setLoginPassword(loginDto.getLoginPassword());
		login.setLoginUsername(loginDto.getLoginUsername());
		login.setAccount(loginDto.getAccount());
		loginRepository.save(login);
	}

}
