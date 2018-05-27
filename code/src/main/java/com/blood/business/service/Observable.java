package com.blood.business.service;

import com.blood.presentation.controller.Observer;

public interface Observable {
	public void registerObserver(Observer o);

	public void unregisterObserver(Observer o);

	public void notifyObservers(String message);
}
