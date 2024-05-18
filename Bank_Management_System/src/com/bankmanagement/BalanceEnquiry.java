package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JLabel label2;
	JButton b1;
	int pin;

	public BalanceEnquiry(int pin) {
		super("Balance Enquiry");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 10, 1550, 830);
		add(image);

		this.pin = pin;

		JLabel label1 = new JLabel("Your current balance is");
		label1.setFont(new Font("System", Font.BOLD, 16));
		label1.setBounds(430, 180, 700, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		label2 = new JLabel();
		label2.setFont(new Font("System", Font.BOLD, 16));
		label2.setBounds(430, 220, 500, 35);
		label2.setForeground(Color.WHITE);
		image.add(label2);

		b1 = new JButton("Back");
		b1.setBounds(700, 406, 150, 35);
		b1.setBackground(new Color(65, 125, 128));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);

		int balance = 0;

		try {
			Conn connection = new Conn();
			ResultSet resultResult = connection.statement.executeQuery("select * from bank where pin = '" + pin + "'");

			while (resultResult.next()) {
				/*
				 * if(resultResult.getString("type").equals("Deposite")) { balance +=
				 * Integer.parseInt(resultResult.getString("amount")); }else { balance -=
				 * Integer.parseInt(resultResult.getString("amount")); }
				 */
				balance = Integer.parseInt(resultResult.getString("amount"));
			}

			label2.setText("" + balance);

		} catch (Exception E) {
			E.printStackTrace();
		}

		setLayout(null);
		setUndecorated(true);

		//getContentPane().setBackground(new Color(252, 208, 76));
		setSize(1550, 1080);
		setLocation(0, 0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {

			new Main_Class(pin);
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry(0);
	}

}
