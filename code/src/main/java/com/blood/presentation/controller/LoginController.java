package com.blood.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blood.business.dto.AccountDto;
import com.blood.business.dto.LoginDto;
import com.blood.business.dto.PatientDto;
import com.blood.business.service.AccountService;
import com.blood.business.service.LoginService;
import com.blood.business.service.PatientService;
import com.blood.presentation.view.DonorView;
import com.blood.presentation.view.LoginView;
import com.blood.presentation.view.PatientView;

@Controller
public class LoginController {
	@Autowired
	LoginView loginView;
	@Autowired
	LoginStrategy strategy;
	@Autowired
	PatientService patientService;
	@Autowired
	LoginService loginService;
	@Autowired
	AccountService accountService;
	LoginDto loginDto = new LoginDto();

	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		loginView.setPatientLoginListener(new PatientLoginListener());
		loginView.setDonorLoginListener(new DonorLoginListener());
		// loginView.setCreateDonorListener(new CreateDonorListener());
		loginView.setCreatePatientListener(new CreatePatientListener());
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	private class PatientLoginListener implements ActionListener {

		String username = "";
		String password = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginView.loginPatientBtn) {
				PatientView patientView = new PatientView();
				PatientController patientController = new PatientController(patientView, patientService, loginService,
						accountService);

				int optionPaneResult = loginView.getLoginOptionPane();
				if (optionPaneResult == JOptionPane.OK_OPTION) {
					username = loginView.usernameText.getText();
					password = loginView.passwordText.getText();
					//try {
						loginDto = loginService.getLogin(username, password);
						patientController.setPatientId(loginDto.getAccount().getPatient().getPatientId());
						if (loginDto != null) {
							strategy.processLogin(patientView.patientFrame);
							patientController.displayDonors();
						}
					//} catch (Exception exception) {
						//JOptionPane.showMessageDialog(loginView.panelLogin, "Invalid username or password", "Error",
								//JOptionPane.ERROR_MESSAGE);
					//}
				} else {
					System.out.println("Cancelled");
				}
			}

		}
	}

	private class DonorLoginListener implements ActionListener {
		String username = "";
		String password = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginView.loginDonorBtn) {
				DonorView donorView = new DonorView();
				DonorController donorController = new DonorController(donorView);
				int optionPaneResult = loginView.getLoginOptionPane();

				if (optionPaneResult == JOptionPane.OK_OPTION) {
					username = loginView.usernameText.getText();
					password = loginView.passwordText.getText();

					System.out.println("User:" + username + " pass: " + password);
					LoginDto loginDto = loginService.getLogin(username, password);
					if (loginDto != null) {
						strategy.processLogin(donorView.donorFrame);

					} else {
						JOptionPane.showMessageDialog(loginView.panelLogin, "Invalid username or password", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println("Cancelled");
				}
			}

		}
	}

	// private class CreateDonorListener implements ActionListener {
	// String name = "";
	// String username = "";
	// String password = "";
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if (e.getSource() == loginView.createWriterBtn) {
	// WriterView writerView = new WriterView();
	// int optionPaneResult = homeView.createProfileOptionPane();
	// if (optionPaneResult == JOptionPane.OK_OPTION) {
	// name = homeView.profileNameText.getText();
	// username = homeView.profileUsernameText.getText();
	// password = homeView.profilePasswordText.getText();
	// String nameAndUsernameAndPassword = name + " " + username + " " + password;
	// WriterController writerController = new WriterController(writerView);
	// try {
	// writerController.createProfile(writerController, nameAndUsernameAndPassword);
	// } catch (JSONException e1) {
	// e1.printStackTrace();
	// }
	// } else {
	// System.out.println("Cancelled");
	// }
	// }
	//
	// }
	// }

	private class CreatePatientListener implements ActionListener {
		String firstname = "";
		String lastname = "";
		String email = "";
		String username = "";
		String password = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginView.createPatientProfileBtn) {
				System.out.println("aa");
				PatientView patientView = new PatientView();
				PatientController patientController = new PatientController(patientView, patientService, loginService, accountService);
				
				int optionPaneResult = loginView.getPatientProfileOptionPane();

				if (optionPaneResult == JOptionPane.OK_OPTION) {
					firstname = loginView.patientFirstnameText.getText();
					lastname = loginView.patientLastnameText.getText();
					email = loginView.patientEmailText.getText();
					username = loginView.patientUsernameText.getText();
					password = loginView.patientPasswordText.getText();
					try {
						LoginDto loginDto = new LoginDto(username, password);
						PatientDto patientDto = new PatientDto(firstname, lastname);
						AccountDto accountDto = new AccountDto("patient", email, patientService.createPatient(patientDto));				
						loginDto.setAccount(accountService.createAccount(accountDto));
						loginService.createLogin(loginDto);
			
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(loginView.panelLogin, "Invalid input!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println("Cancelled");
				}
			}
		}
	}

}
