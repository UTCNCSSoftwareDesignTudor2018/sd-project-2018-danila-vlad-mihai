package com.blood.business.validator;

import java.util.regex.Pattern;

import com.blood.business.dto.LoginDto;

public class PasswordValidator implements Validator<LoginDto> {
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";

	@Override
	public boolean validate(LoginDto loginDto) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		if (!pattern.matcher(loginDto.getLoginPassword()).matches()) {
			return false;
		}
		return true;
	}

}
