package com.blood.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

import com.blood.business.dto.DonorDto;
import com.blood.business.dto.PatientDto;
import com.blood.business.service.AccountService;
import com.blood.business.service.DonorService;
import com.blood.business.service.LoginService;
import com.blood.business.service.PatientService;
import com.blood.presentation.view.PatientView;

@Controller
@Primary
public class PatientController implements LoginStrategy, Observer {
	@Autowired
	PatientView patientView;
	@Autowired
	PatientService patientService;
	@Autowired
	LoginService loginService;
	@Autowired
	LoginController loginController;
	@Autowired
	AccountService accountService;
	@Autowired
	DonorService donorService;
	private int patientId;

	public PatientController(PatientView patientView, PatientService patientService, LoginService loginService,
			AccountService accountService, DonorService donorService) {
		this.patientView = patientView;
		this.patientService = patientService;
		this.loginService = loginService;
		this.accountService = accountService;
		this.donorService = donorService;
		patientView.setPatientViewInfoListener(new ViewPatientInfoListener());
		patientView.setPatientUpdateListener(new UpdatePatientListener());
		patientView.setPatientDeleteListener(new DeletePatientListener());
		patientView.setDonorSearchListener(new SearchDonorListener());

	}

	public void displayDonors() {
		List<DonorDto> donorDtoList = donorService.getDonors();
		for (DonorDto d : donorDtoList) {
			patientView.donorsModel.addElement(d.toString());
		}

	}

	public void setPatientView(PatientView patientView) {
		this.patientView = patientView;
	}

	@Override
	public void processLogin(JFrame frame) {
		frame.setVisible(true);
	}

	private class ViewPatientInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == patientView.viewPatientBtn) {
				PatientDto patientDto = new PatientDto();
				patientDto = patientService.findPatientById(patientId);
				JOptionPane.showMessageDialog(patientView.patientPanel, patientDto.getPatientFirstname() + " "
						+ patientDto.getPatientLastname() + "\n" + patientDto.getAccounts());
			}
		}
	}

	private class UpdatePatientListener implements ActionListener {
		private String password = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == patientView.updatePatientBtn) {
				password = patientView.passwordNewText.getText();
				PatientDto patientDto = new PatientDto();
				patientDto = patientService.findPatientById(patientId);
				loginService.updateLoginPassword(patientDto.getAccounts().get(0).getLogin().getLoginId(), password);

				JOptionPane.showMessageDialog(patientView.patientPanel, patientDto.getPatientFirstname() + " "
						+ patientDto.getPatientLastname() + " your password is updated!");
			}
		}
	}

	private class DeletePatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == patientView.deletePatientBtn) {

				PatientDto patientDto = new PatientDto();
				patientDto = patientService.findPatientById(patientId);

				accountService.deleteAccount(patientDto.getAccounts().get(0).getAccountId());
				patientService.deletePatient(patientDto.getAccounts().get(0).getPatient().getPatientId());

				JOptionPane.showMessageDialog(patientView.patientPanel, patientDto.getPatientFirstname() + " "
						+ patientDto.getPatientLastname() + " your account is deleted!");
				patientView.patientFrame.dispose();
			}
		}
	}

	private class SearchDonorListener implements ActionListener {
		String bloodType = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == patientView.searchDonorBtn) {
				bloodType = patientView.bloodTypeText.getText();
				System.out.println(bloodType + "aa");
				List<DonorDto> donorDtoList = donorService.getCompatibleDonors(bloodType);
				for (DonorDto d : donorDtoList) {
					patientView.donorsFoundModel.addElement(d.toString());
				}

			}
		}
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public void update(String message) {
		if(message.equals("statesChanged")) {
		patientView.donorsModel.clear();
		displayDonors();
		}
		else {
			patientView.donorsModel.clear();
			displayDonors();
			JOptionPane.showMessageDialog(patientView.patientPanel, message);
		}
		

	}

}
