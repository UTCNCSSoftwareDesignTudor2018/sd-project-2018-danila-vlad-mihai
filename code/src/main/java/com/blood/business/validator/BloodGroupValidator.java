package com.blood.business.validator;

import java.util.regex.Pattern;

import com.blood.business.dto.BloodBankDto;
import com.blood.business.dto.LoginDto;

public class BloodGroupValidator implements Validator<BloodBankDto> {
	private static final String BLOOD_PATTERN = "^(A|B|AB|O)[+-]$";

	@Override
	public boolean validate(BloodBankDto bloodBankDto) {
		Pattern pattern = Pattern.compile(BLOOD_PATTERN);
		if (!pattern.matcher(bloodBankDto.getBloodType()).matches()) {
			return false;
		}
		return true;
	}

}
