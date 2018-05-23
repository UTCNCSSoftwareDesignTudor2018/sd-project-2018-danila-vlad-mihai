package com.blood.presentation.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class DonorView {
	public JFrame donorFrame;
	public JPanel donorPanel;

	public DonorView() {
		initialize();
	}

	private void initialize() {
		donorFrame = new JFrame();
		donorFrame.setBounds(0, 0, 850, 450);
		donorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		donorFrame.setLocationRelativeTo(null);
		donorFrame.getContentPane().setLayout(null);
		donorFrame.setTitle("Donor");

		donorPanel = new JPanel();
		donorPanel.setLayout(null);
		donorPanel.setBounds(0, 0, 850, 450);
		donorPanel.setVisible(true);
		donorPanel.setBackground(Color.GRAY);

	}

}
