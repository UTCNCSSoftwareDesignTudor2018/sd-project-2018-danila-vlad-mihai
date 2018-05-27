package com.blood.business.validator;

public interface Validator<T> {
	public boolean validate(T t);
}
