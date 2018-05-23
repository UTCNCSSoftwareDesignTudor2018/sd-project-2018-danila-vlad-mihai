package com.blood.presentation.controller;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public interface LoginStrategy {
	public void processLogin(JFrame frame);

}
