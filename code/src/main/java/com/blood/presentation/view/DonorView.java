package com.blood.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import org.springframework.stereotype.Component;

@Component
public class DonorView {
	public JFrame donorFrame;
	public JPanel donorPanel;

	public JButton viewDonorBtn;
	public JButton updateDonorBtn;
	public JButton deleteDonorBtn;

	public JCheckBox checkAvailabilitybox;

	public JScrollPane listScrollPane;
	public JList<String> patientsList;
	public DefaultListModel<String> patientsModel;

	public DonorView() {
		initialize();
	}

	public void setDonorViewInfoListener(ActionListener actionListener) {
		viewDonorBtn.addActionListener(actionListener);
	}

	public void setDonorUpdateListener(ActionListener actionListener) {
		updateDonorBtn.addActionListener(actionListener);
	}

	public void setDonorDeleteListener(ActionListener actionListener) {
		deleteDonorBtn.addActionListener(actionListener);
	}

	private void initialize() {
		donorFrame = new JFrame();
		donorFrame.setBounds(0, 0, 645, 330);
		donorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		donorFrame.setLocationRelativeTo(null);
		donorFrame.getContentPane().setLayout(null);
		donorFrame.setTitle("Donor");

		donorPanel = new JPanel();
		donorPanel.setLayout(null);
		donorPanel.setBounds(0, 0, 645, 330);
		donorPanel.setVisible(true);
		donorFrame.add(donorPanel);

		patientsModel = new DefaultListModel<>();
		patientsList = new JList<>(patientsModel);
		patientsList.setBounds(10, 10, 450, 250);
		patientsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		patientsList.setLayoutOrientation(JList.VERTICAL);
		donorPanel.add(patientsList);

		listScrollPane = new JScrollPane(patientsList);
		listScrollPane.setBounds(10, 10, 450, 250);
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		donorPanel.add(listScrollPane);

		viewDonorBtn = new JButton("View info");
		viewDonorBtn.setBounds(480, 10, 120, 20);
		donorPanel.add(viewDonorBtn);

		deleteDonorBtn = new JButton("Delete profile");
		deleteDonorBtn.setBounds(480, 80, 120, 20);
		donorPanel.add(deleteDonorBtn);

		checkAvailabilitybox = new JCheckBox("Available to donate: ");
		checkAvailabilitybox.setSelected(false);
		checkAvailabilitybox.setBounds(480, 150, 160, 20);
		donorPanel.add(checkAvailabilitybox);

		updateDonorBtn = new JButton("Update profile");
		updateDonorBtn.setBounds(480, 180, 120, 20);
		donorPanel.add(updateDonorBtn);

	}

}
