package com.blood.presentation.controller;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.blood.presentation.view.DonorView;

@Controller
@Component("donor")
public class DonorController implements LoginStrategy{
	@Autowired
	DonorView donorView;
	
	public DonorController(DonorView donorView) {
		this.donorView = donorView;

	}
	
	public void setDonorView(DonorView donorView) {
		this.donorView = donorView;
	}

	@Override
	public void processLogin(JFrame frame) {
		frame.setVisible(true);
		
	}
}
