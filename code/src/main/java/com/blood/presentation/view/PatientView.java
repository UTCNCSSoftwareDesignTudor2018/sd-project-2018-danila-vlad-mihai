package com.blood.presentation.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import org.springframework.stereotype.Component;

@Component
public class PatientView {
	public JFrame patientFrame;
	public JPanel patientPanel;

	public JTextField passwordNewText;
	public JTextField bloodTypeText;

	public JButton viewPatientBtn;
	public JButton updatePatientBtn;
	public JButton deletePatientBtn;
	public JButton searchDonorBtn;

	public JScrollPane listScrollPane;
	public JList<String> donorsList;
	public DefaultListModel<String> donorsModel;

	public JScrollPane listFoundScrollPane;
	public JList<String> donorsFoundList;
	public DefaultListModel<String> donorsFoundModel;

	public PatientView() {
		initialize();
	}

	public void setPatientViewInfoListener(ActionListener actionListener) {
		viewPatientBtn.addActionListener(actionListener);
	}

	public void setPatientUpdateListener(ActionListener actionListener) {
		updatePatientBtn.addActionListener(actionListener);
	}

	public void setPatientDeleteListener(ActionListener actionListener) {
		deletePatientBtn.addActionListener(actionListener);
	}

	public void setDonorSearchListener(ActionListener actionListener) {
		searchDonorBtn.addActionListener(actionListener);
	}

	private void initialize() {
		patientFrame = new JFrame();
		patientFrame.setBounds(0, 0, 870, 330);
		patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		patientFrame.setLocationRelativeTo(null);
		patientFrame.getContentPane().setLayout(null);
		patientFrame.setTitle("Patient");

		patientPanel = new JPanel();
		patientPanel.setLayout(null);
		patientPanel.setBounds(0, 0, 870, 330);
		patientPanel.setVisible(true);
		patientPanel.setBackground(Color.GRAY);
		patientFrame.add(patientPanel);

		donorsFoundModel = new DefaultListModel<>();
		donorsFoundList = new JList<>(donorsFoundModel);
		donorsFoundList.setBounds(470, 80, 370, 175);
		donorsFoundList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		donorsFoundList.setLayoutOrientation(JList.VERTICAL);
		patientPanel.add(donorsFoundList);

		listFoundScrollPane = new JScrollPane(donorsFoundList);
		listFoundScrollPane.setBounds(470, 80, 370, 175);
		listFoundScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		patientPanel.add(listFoundScrollPane);

		donorsModel = new DefaultListModel<>();
		donorsList = new JList<>(donorsModel);
		donorsList.setBounds(10, 10, 450, 250);
		donorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		donorsList.setLayoutOrientation(JList.VERTICAL);
		patientPanel.add(donorsList);

		listScrollPane = new JScrollPane(donorsList);
		listScrollPane.setBounds(10, 10, 450, 250);
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		patientPanel.add(listScrollPane);

		passwordNewText = new JTextField("New password");
		passwordNewText.setBounds(470, 10, 120, 20);
		patientPanel.add(passwordNewText);

		bloodTypeText = new JTextField("Blood type");
		bloodTypeText.setBounds(470, 50, 120, 20);
		patientPanel.add(bloodTypeText);

		viewPatientBtn = new JButton("View info");
		viewPatientBtn.setBounds(720, 50, 120, 20);
		patientPanel.add(viewPatientBtn);

		updatePatientBtn = new JButton("Update profile");
		updatePatientBtn.setBounds(595, 10, 120, 20);
		patientPanel.add(updatePatientBtn);

		deletePatientBtn = new JButton("Delete profile");
		deletePatientBtn.setBounds(720, 10, 120, 20);
		patientPanel.add(deletePatientBtn);

		searchDonorBtn = new JButton("Search donor");
		searchDonorBtn.setBounds(595, 50, 120, 20);
		patientPanel.add(searchDonorBtn);

	}

}
