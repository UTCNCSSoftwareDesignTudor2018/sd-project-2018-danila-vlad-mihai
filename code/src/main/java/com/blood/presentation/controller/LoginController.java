package com.blood.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blood.business.dto.AccountAddressDto;
import com.blood.business.dto.AccountDto;
import com.blood.business.dto.AddressDto;
import com.blood.business.dto.BloodBankDto;
import com.blood.business.dto.DonorDto;
import com.blood.business.dto.LoginDto;
import com.blood.business.dto.PatientDto;
import com.blood.business.service.AccountService;
import com.blood.business.service.DonorService;
import com.blood.business.service.LoginService;
import com.blood.business.service.PatientService;
import com.blood.business.validator.BloodGroupValidator;
import com.blood.business.validator.PasswordValidator;
import com.blood.business.validator.Validator;
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
	@Autowired
	DonorService donorService;
	LoginDto loginDto = new LoginDto();

	private static List<Validator<LoginDto>> loginValidators;
	private static List<Validator<BloodBankDto>> bloodValidators;

	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		loginView.setPatientLoginListener(new PatientLoginListener());
		loginView.setDonorLoginListener(new DonorLoginListener());
		loginView.setCreateDonorListener(new CreateDonorListener());
		loginView.setCreatePatientListener(new CreatePatientListener());
		loginValidators = new ArrayList<Validator<LoginDto>>();
		bloodValidators = new ArrayList<Validator<BloodBankDto>>();
		loginValidators.add(new PasswordValidator());
		bloodValidators.add(new BloodGroupValidator());
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
						accountService, donorService);

				int optionPaneResult = loginView.getLoginOptionPane();
				if (optionPaneResult == JOptionPane.OK_OPTION) {
					username = loginView.usernameText.getText();
					password = loginView.passwordText.getText();
					try {
						loginDto = loginService.getLogin(username, password);
						patientController.setPatientId(loginDto.getAccount().getPatient().getPatientId());
						if (loginDto != null) {
							strategy.processLogin(patientView.patientFrame);
							donorService.getObserverList().add(patientController);
							patientController.displayDonors();
						}
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(loginView.panelLogin, "Invalid username or password", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
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
				DonorController donorController = new DonorController(donorView, patientService, loginService,
						accountService, donorService);

				int optionPaneResult = loginView.getLoginOptionPane();
				if (optionPaneResult == JOptionPane.OK_OPTION) {
					username = loginView.usernameText.getText();
					password = loginView.passwordText.getText();
					try {
						loginDto = loginService.getLogin(username, password);
						donorController.setDonorId(loginDto.getAccount().getDonor().getDonorId());
						if (loginDto != null) {
							strategy.processLogin(donorView.donorFrame);
							donorController.displayPatients();
						}
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(loginView.panelLogin, "Invalid username or password", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println("Cancelled");
				}
			}

		}
	}

	private class CreatePatientListener implements ActionListener {
		String firstname = "";
		String lastname = "";
		String email = "";
		String address = "";
		String username = "";
		String password = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginView.createPatientProfileBtn) {
				PatientView patientView = new PatientView();
				PatientController patientController = new PatientController(patientView, patientService, loginService,
						accountService, donorService);

				int optionPaneResult = loginView.getPatientProfileOptionPane();

				if (optionPaneResult == JOptionPane.OK_OPTION) {
					firstname = loginView.patientFirstnameText.getText();
					lastname = loginView.patientLastnameText.getText();
					email = loginView.patientEmailText.getText();
					username = loginView.patientUsernameText.getText();
					password = loginView.patientPasswordText.getText();
					address = loginView.patientAddressText.getText();

					PasswordValidator passwordValidator = new PasswordValidator();

					LoginDto loginDto = new LoginDto(username, password);

					if (passwordValidator.validate(loginDto)) {
						PatientDto patientDto = new PatientDto(firstname, lastname);
						AccountDto accountDto = new AccountDto("patient", email,
								patientService.createPatient(patientDto));

						loginDto.setAccount(accountService.createAccount(accountDto));
						loginService.createLogin(loginDto);
						AccountAddressDto accountAddressDto;
						if (accountService.getAddress(address) != null) {
							accountAddressDto = new AccountAddressDto(accountService.getAddress(address),
									loginDto.getAccount());
						} else {
							AddressDto addressDto = new AddressDto(address);

							accountAddressDto = new AccountAddressDto(accountService.createAddress(addressDto),
									loginDto.getAccount());
						}
						accountService.createAccountAddress(accountAddressDto);
					} else {
						JOptionPane.showMessageDialog(loginView.panelLogin,
								"Invalid input! Please make sure that the password contains: uppercase letter, lowercase letter, digit!",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println("Cancelled");
				}
			}
		}
	}

	private class CreateDonorListener implements ActionListener {
		String firstname = "";
		String lastname = "";
		String email = "";
		String address = "";
		String username = "";
		String password = "";
		String availability = "";
		String bloodType = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginView.createDonorProfileBtn) {
				DonorView donorView = new DonorView();
				DonorController donorController = new DonorController(donorView, patientService, loginService,
						accountService, donorService);

				int optionPaneResult = loginView.getDonorProfileOptionPane();

				if (optionPaneResult == JOptionPane.OK_OPTION) {
					firstname = loginView.donorFirstnameText.getText();
					lastname = loginView.donorLastnameText.getText();
					email = loginView.donorEmailText.getText();
					username = loginView.donorUsernameText.getText();
					password = loginView.donorPasswordText.getText();
					address = loginView.donorAddressText.getText();

					PasswordValidator passwordValidator = new PasswordValidator();
					BloodGroupValidator bloodValidator = new BloodGroupValidator();

					LoginDto loginDto = new LoginDto(username, password);

					if (loginView.checkbox.isSelected())
						availability = "true";
					else
						availability = "false";
					bloodType = loginView.donorBloodTypeText.getText();
					BloodBankDto bloodBankDto = new BloodBankDto();
					bloodBankDto.setBloodType(bloodType);

					if (passwordValidator.validate(loginDto) && bloodValidator.validate(bloodBankDto)) {
						DonorDto donorDto = new DonorDto(firstname, lastname, availability,
								donorService.getBloodBank(bloodType));

						AccountDto accountDto = new AccountDto("donor", email, donorService.createDonor(donorDto));

						loginDto.setAccount(accountService.createAccount(accountDto));
						loginService.createLogin(loginDto);
						AccountAddressDto accountAddressDto;
						if (accountService.getAddress(address) != null) {
							accountAddressDto = new AccountAddressDto(accountService.getAddress(address),
									loginDto.getAccount());
						} else {
							AddressDto addressDto = new AddressDto(address);

							accountAddressDto = new AccountAddressDto(accountService.createAddress(addressDto),
									loginDto.getAccount());
						}
						accountService.createAccountAddress(accountAddressDto);

					} else {
						JOptionPane.showMessageDialog(loginView.panelLogin,
								"Invalid input! Please make sure that:\n-The password contains uppercase letter, lowercase letter, digit\n-Blood group is one of type: A-, A+, B-, B+, AB+, AB-, 0-, 0+",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println("Cancelled");
				}
			}
		}
	}

}
