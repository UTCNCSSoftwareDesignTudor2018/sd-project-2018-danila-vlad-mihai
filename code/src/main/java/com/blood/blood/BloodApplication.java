package com.blood.blood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blood.presentation.controller.LoginController;
import com.blood.presentation.view.LoginView;

@SpringBootApplication
public class BloodApplication implements CommandLineRunner{
	@Autowired
	LoginView loginView;
	@Autowired
	LoginController loginController;


	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(BloodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loginView.getFrame().setVisible(true);
		loginController.setHomeView(homeView);
	}
}
