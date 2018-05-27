package com.blood.presentation.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class LoginView {
	private JFrame frame;

	public JPanel panelLogin;
	public JPanel panelLoginData;
	public JPanel createDonorProfilePanel;
	public JPanel createPatientProfilePanel;

	public JTextField usernameText;
	public JPasswordField passwordText;

	public JButton loginPatientBtn;
	public JButton loginDonorBtn;
	public JButton createDonorProfileBtn;
	public JButton createPatientProfileBtn;

	public JTextField donorFirstnameText;
	public JTextField donorLastnameText;
	public JTextField donorEmailText;
	public JTextField donorAddressText;
	public JTextField donorUsernameText;
	public JPasswordField donorPasswordText;
	public JCheckBox checkbox;
	public JTextField donorBloodTypeText;

	public JTextField patientFirstnameText;
	public JTextField patientLastnameText;
	public JTextField patientEmailText;
	public JTextField patientAddressText;
	public JTextField patientUsernameText;
	public JPasswordField patientPasswordText;

	public LoginView() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setPatientLoginListener(ActionListener actionListener) {
		loginPatientBtn.addActionListener(actionListener);
	}

	public void setDonorLoginListener(ActionListener actionListener) {
		loginDonorBtn.addActionListener(actionListener);
	}

	public void setCreateDonorListener(ActionListener actionListener) {
		createDonorProfileBtn.addActionListener(actionListener);
	}

	public void setCreatePatientListener(ActionListener actionListener) {
		createPatientProfileBtn.addActionListener(actionListener);
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 300, 150);
		panelLogin.setBackground(Color.GRAY);
		panelLogin.setLayout(null);
		frame.add(panelLogin);

		loginPatientBtn = new JButton("Patient login");
		loginPatientBtn.setBounds(75, 20, 130, 25);
		panelLogin.add(loginPatientBtn);

		loginDonorBtn = new JButton("Donor Login");
		loginDonorBtn.setBounds(75, 50, 130, 25);
		panelLogin.add(loginDonorBtn);

		usernameText = new JTextField();
		passwordText = new JPasswordField();

		panelLoginData = new JPanel(new GridLayout(0, 1));
		panelLoginData.add(new JLabel("Username:"));
		panelLoginData.add(usernameText);
		panelLoginData.add(new JLabel("Password:"));
		panelLoginData.add(passwordText);

		createDonorProfileBtn = new JButton("Create donor profile");
		panelLoginData.add(createDonorProfileBtn);
		createPatientProfileBtn = new JButton("Create patient profile");
		panelLoginData.add(createPatientProfileBtn);

		donorFirstnameText = new JTextField();
		donorLastnameText = new JTextField();
		donorEmailText = new JTextField();
		donorAddressText = new JTextField();
		donorUsernameText = new JTextField();
		donorPasswordText = new JPasswordField();

		donorBloodTypeText = new JTextField();
		patientFirstnameText = new JTextField();
		patientLastnameText = new JTextField();
		patientEmailText = new JTextField();
		patientAddressText = new JTextField();
		patientUsernameText = new JTextField();
		patientPasswordText = new JPasswordField();

		createDonorProfilePanel = new JPanel(new GridLayout(0, 1));
		createDonorProfilePanel.add(new JLabel("First name:"));
		createDonorProfilePanel.add(donorFirstnameText);
		createDonorProfilePanel.add(new JLabel("Last name:"));
		createDonorProfilePanel.add(donorLastnameText);
		createDonorProfilePanel.add(new JLabel("Email:"));
		createDonorProfilePanel.add(donorEmailText);
		createDonorProfilePanel.add(new JLabel("Address:"));
		createDonorProfilePanel.add(donorAddressText);
		createDonorProfilePanel.add(new JLabel("Username:"));
		createDonorProfilePanel.add(donorUsernameText);
		createDonorProfilePanel.add(new JLabel("Password:"));
		createDonorProfilePanel.add(donorPasswordText);
		createDonorProfilePanel.add(new JLabel("Blood type:"));
		createDonorProfilePanel.add(donorBloodTypeText);
		checkbox = new JCheckBox("Set as available");
		checkbox.setSelected(false);
		createDonorProfilePanel.add(checkbox);

		createPatientProfilePanel = new JPanel(new GridLayout(0, 1));
		createPatientProfilePanel.add(new JLabel("First name:"));
		createPatientProfilePanel.add(patientFirstnameText);
		createPatientProfilePanel.add(new JLabel("Last name:"));
		createPatientProfilePanel.add(patientLastnameText);
		createPatientProfilePanel.add(new JLabel("Email:"));
		createPatientProfilePanel.add(patientEmailText);
		createPatientProfilePanel.add(new JLabel("Address:"));
		createPatientProfilePanel.add(patientAddressText);
		createPatientProfilePanel.add(new JLabel("Username:"));
		createPatientProfilePanel.add(patientUsernameText);
		createPatientProfilePanel.add(new JLabel("Password:"));
		createPatientProfilePanel.add(patientPasswordText);

	}

	public int getLoginOptionPane() {
		return JOptionPane.showConfirmDialog(null, panelLoginData, "Login", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
	}

	public int getDonorProfileOptionPane() {
		return JOptionPane.showConfirmDialog(null, createDonorProfilePanel, "Create donor profile",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	public int getPatientProfileOptionPane() {
		return JOptionPane.showConfirmDialog(null, createPatientProfilePanel, "Create patient profile",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}
}
