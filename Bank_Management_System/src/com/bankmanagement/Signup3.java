package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup3 extends JFrame implements ActionListener {

	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	String formno;
	JButton s, c;

	public Signup3(String formNo) {

		super("Application Form");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(100, 5, 100, 100);
		add(image);

		this.formno = formNo;

		JLabel label1 = new JLabel("Page 3: ");
		label1.setFont(new Font("Ralway", Font.BOLD, 22));
		label1.setBounds(280, 40, 400, 40);
		add(label1);

		JLabel labelDetails = new JLabel("Account Details: ");
		labelDetails.setFont(new Font("Ralway", Font.BOLD, 22));
		labelDetails.setBounds(280, 70, 400, 40);
		add(labelDetails);

		JLabel labelType = new JLabel("Account Type: ");
		labelType.setFont(new Font("Ralway", Font.BOLD, 18));
		labelType.setBounds(100, 140, 200, 30);
		add(labelType);

		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Ralway", Font.BOLD, 14));
		r1.setBounds(100, 180, 200, 30);
		r1.setBackground(new Color(215, 225, 225));
		add(r1);

		r2 = new JRadioButton("Fixed Account");
		r2.setFont(new Font("Ralway", Font.BOLD, 14));
		r2.setBounds(350, 180, 200, 30);
		r2.setBackground(new Color(215, 225, 225));
		add(r2);

		r3 = new JRadioButton("Currenct Account");
		r3.setFont(new Font("Ralway", Font.BOLD, 14));
		r3.setBounds(100, 220, 200, 30);
		r3.setBackground(new Color(215, 225, 225));
		add(r3);

		r4 = new JRadioButton("Recurring Account");
		r4.setFont(new Font("Ralway", Font.BOLD, 14));
		r4.setBounds(350, 220, 200, 30);
		r4.setBackground(new Color(215, 225, 225));
		add(r4);

		ButtonGroup btn = new ButtonGroup();
		btn.add(r1);
		btn.add(r2);
		btn.add(r3);
		btn.add(r4);

		JLabel labelNumber = new JLabel("Card Number: ");
		labelNumber.setFont(new Font("Ralway", Font.BOLD, 18));
		labelNumber.setBounds(100, 300, 200, 30);
		add(labelNumber);

		JLabel labelDigit = new JLabel("(Your 16 Digit card number)");
		labelDigit.setFont(new Font("Ralway", Font.BOLD, 12));
		labelDigit.setBounds(100, 330, 300, 20);
		add(labelDigit);

		JLabel labelShow = new JLabel("XXXX-XXXX-XXXX-6595");
		labelShow.setFont(new Font("Ralway", Font.BOLD, 16));
		labelShow.setBounds(330, 300, 300, 20);
		add(labelShow);

		JLabel labelApper = new JLabel("(It should appear on card or check book)");
		labelApper.setFont(new Font("Ralway", Font.BOLD, 12));
		labelApper.setBounds(330, 330, 350, 20);
		add(labelApper);

		JLabel labelPin = new JLabel("PIN :");
		labelPin.setFont(new Font("Ralway", Font.BOLD, 18));
		labelPin.setBounds(100, 370, 300, 30);
		add(labelPin);

		JLabel labelPinS = new JLabel("XXXX");
		labelPinS.setFont(new Font("Ralway", Font.BOLD, 18));
		labelPinS.setBounds(330, 370, 300, 30);
		add(labelPinS);

		JLabel labelPass = new JLabel("(4-Digit pin)");
		labelPass.setFont(new Font("Ralway", Font.BOLD, 12));
		labelPass.setBounds(100, 400, 350, 20);
		add(labelPass);

		JLabel labelService = new JLabel("Services Required :");
		labelService.setFont(new Font("Ralway", Font.BOLD, 18));
		labelService.setBounds(100, 420, 300, 30);
		add(labelService);

		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Ralway", Font.BOLD, 16));
		c1.setBounds(100, 460, 200, 30);
		c1.setBackground(new Color(215, 225, 225));
		add(c1);

		c2 = new JCheckBox("Internate Banking");
		c2.setFont(new Font("Ralway", Font.BOLD, 16));
		c2.setBounds(350, 460, 200, 30);
		c2.setBackground(new Color(215, 225, 225));
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Ralway", Font.BOLD, 16));
		c3.setBounds(100, 510, 200, 30);
		c3.setBackground(new Color(215, 225, 225));
		add(c3);

		c4 = new JCheckBox("Email Alerts");
		c4.setFont(new Font("Ralway", Font.BOLD, 16));
		c4.setBounds(350, 510, 200, 30);
		c4.setBackground(new Color(215, 225, 225));
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Ralway", Font.BOLD, 16));
		c5.setBounds(100, 560, 200, 30);
		c5.setBackground(new Color(215, 225, 225));
		add(c5);

		c6 = new JCheckBox("E-Statements ");
		c6.setFont(new Font("Ralway", Font.BOLD, 16));
		c6.setBounds(350, 560, 200, 30);
		c6.setBackground(new Color(215, 225, 225));
		add(c6);

		c7 = new JCheckBox("I hear by declare that above information is correct best of my knowladge.", true);
		c7.setFont(new Font("Ralway", Font.BOLD, 12));
		c7.setBounds(100, 610, 600, 30);
		c7.setBackground(new Color(215, 225, 225));
		add(c7);

		JLabel labelForm = new JLabel("Form No : ");
		labelForm.setFont(new Font("Ralway", Font.BOLD, 18));
		labelForm.setBounds(600, 10, 100, 30);
		add(labelForm);

		JLabel labelform = new JLabel(formno);
		labelform.setFont(new Font("Ralway", Font.BOLD, 18));
		labelform.setBounds(760, 10, 100, 30);
		add(labelform);

		s = new JButton("Submit");
		s.setFont(new Font("Ralway", Font.BOLD, 14));
		s.setBackground(Color.WHITE);
		s.setForeground(Color.BLACK);
		s.setBounds(250, 720, 100, 30);
		s.addActionListener(this);
		add(s);

		c = new JButton("Cancel");
		c.setFont(new Font("Ralway", Font.BOLD, 14));
		c.setBackground(Color.WHITE);
		c.setForeground(Color.BLACK);
		c.setBounds(500, 720, 100, 30);
		c.addActionListener(this);
		add(c);

		setLayout(null);
		getContentPane().setBackground(new Color(215, 225, 225));
		setSize(850, 800);
		setLocation(360, 40);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String atype = null;
		if (r1.isSelected()) {
			atype = "Saving Account";
		} else if (r2.isSelected()) {
			atype = "Fixed Deposit Account";
		} else if (r3.isSelected()) {
			atype = "Current Account";
		} else if (r4.isSelected()) {
			atype = "Recurring Deposit Account";
		}

		Random ran = new Random();
		long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
		String cardno = "" + Math.abs(first7);

		long first3 = (ran.nextLong() % 9000L) + 1000L;
		String pin = "" + Math.abs(first3);

		String fac = "";
		if (c1.isSelected()) {
			fac = fac + "ATM CARD ";
		} else if (c2.isSelected()) {
			fac = fac + "Internet Banking";
		} else if (c3.isSelected()) {
			fac = fac + "Mobile Banking";
		} else if (c4.isSelected()) {
			fac = fac + "EMAIL Alerts";
		} else if (c5.isSelected()) {
			fac = fac + "Cheque Book";
		} else if (c6.isSelected()) {
			fac = fac + "E-Statement";
		}

		try {
			if (e.getSource() == s) {
				if (atype.equals(""))
					JOptionPane.showMessageDialog(null, "Please Fill the all fields ");
				else {
					Conn connection = new Conn();
					String query = "insert into signupthree values('" + formno + "', '" + atype + "', '" + cardno
							+ "', '" + pin + "' , '" + fac + "')";
					String q = "insert into login values('" + formno + "', '" + cardno + "', '" + pin + "' )";
					connection.statement.executeUpdate(query);
					connection.statement.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "Card No : " + cardno + " \n Pin " + pin);
					// new Signup3(formno);
					new Deposite(pin);
					setVisible(false);
				}
			} else if (e.getSource() == c) {
				System.exit(0);
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup3(" ");
	}

}
