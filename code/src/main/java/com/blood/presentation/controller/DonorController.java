package com.blood.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.blood.business.dto.DonorDto;
import com.blood.business.dto.PatientDto;
import com.blood.business.service.AccountService;
import com.blood.business.service.DonorService;
import com.blood.business.service.LoginService;
import com.blood.business.service.PatientService;
import com.blood.presentation.view.DonorView;

@Controller
@Component("donor")
public class DonorController implements LoginStrategy {
	@Autowired
	DonorView donorView;
	@Autowired
	LoginService loginService;
	@Autowired
	AccountService accountService;
	@Autowired
	DonorService donorService;
	@Autowired
	PatientService patientService;
	private int donorId;

	public DonorController(DonorView donorView, PatientService patientService, LoginService loginService,
			AccountService accountService, DonorService donorService) {
		this.donorView = donorView;
		this.patientService = patientService;
		this.loginService = loginService;
		this.accountService = accountService;
		this.donorService = donorService;
		donorView.setDonorViewInfoListener(new ViewDonorInfoListener());
		donorView.setDonorUpdateListener(new UpdateDonorListener());
		donorView.setDonorDeleteListener(new DeleteDonorListener());

	}

	public void setDonorView(DonorView donorView) {
		this.donorView = donorView;
	}

	@Override
	public void processLogin(JFrame frame) {
		frame.setVisible(true);

	}

	public void displayPatients() {
		List<PatientDto> patientDtoList = patientService.getPatients();
		for (PatientDto p : patientDtoList) {
			donorView.patientsModel.addElement(p.toString());
		}

		DonorDto donorDto = new DonorDto();
		donorDto = donorService.findDonorById(donorId);

		if (donorDto.getDonorAvailability() == "true") {
			donorView.checkAvailabilitybox.setSelected(true);
		} else {
			donorView.checkAvailabilitybox.setSelected(false);
		}

	}

	private class ViewDonorInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == donorView.viewDonorBtn) {
				DonorDto donorDto = new DonorDto();
				donorDto = donorService.findDonorById(donorId);
				JOptionPane.showMessageDialog(donorView.donorPanel, donorDto.getDonorFirstname() + " "
						+ donorDto.getDonorLastname() + "\n" + donorDto.getAccounts());
			}
		}
	}

	private class UpdateDonorListener implements ActionListener {
		String availability = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == donorView.updateDonorBtn) {
				if (donorView.checkAvailabilitybox.isSelected())
					availability = "true";
				else
					availability = "false";
				DonorDto donorDto = new DonorDto();
				donorDto = donorService.findDonorById(donorId);
				donorService.updateDonorAvailability(donorDto.getAccounts().get(0).getDonor().getDonorId(),
						availability);
				if (availability.equals("false"))
					JOptionPane.showMessageDialog(donorView.donorPanel, donorDto.getDonorFirstname() + " "
							+ donorDto.getDonorLastname() + " you are no longer available for donations!");
			}
		}
	}

	private class DeleteDonorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == donorView.deleteDonorBtn) {

				DonorDto donorDto = new DonorDto();
				donorDto = donorService.findDonorById(donorId);

				accountService.deleteAccount(donorDto.getAccounts().get(0).getAccountId());
				donorService.deleteDonor(donorDto.getAccounts().get(0).getDonor().getDonorId());

				JOptionPane.showMessageDialog(donorView.donorPanel,
						donorDto.getDonorFirstname() + " " + donorDto.getDonorLastname() + " your account is deleted!");
				donorView.donorFrame.dispose();
			}
		}
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

}
