package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdrwal extends JFrame implements ActionListener {
	String pin;
	TextField textField;
	JButton b1, b2;

	public Withdrwal(String pin) {
		super("Withdrwal ");
		this.pin = pin;

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 1550, 830);
		add(image);

		JLabel label1 = new JLabel("Maximum Withdrwal limit is 10000 Rs ");
		label1.setFont(new Font("System", Font.BOLD, 16));
		label1.setBounds(460, 180, 700, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		JLabel label2 = new JLabel("Please enter your amount ");
		label2.setFont(new Font("System", Font.BOLD, 16));
		label2.setBounds(460, 220, 500, 35);
		label2.setForeground(Color.WHITE);
		image.add(label2);

		textField = new TextField();
		textField.setBackground(new Color(65, 125, 128));
		textField.setBounds(460, 260, 320, 25);
		textField.setFont(new Font("Ralway", Font.BOLD, 22));
		textField.setForeground(Color.WHITE);
		image.add(textField);

		b1 = new JButton("Withdraw");
		b1.setBounds(700, 362, 150, 35);
		b1.setBackground(new Color(65, 125, 128));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);

		b2 = new JButton("Back");
		b2.setBounds(700, 406, 150, 35);
		b2.setBackground(new Color(65, 125, 128));
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		image.add(b2);

		setLayout(null);
		getContentPane().setBackground(new Color(252, 208, 76));
		setSize(1550, 1080);
		setLocation(0, 0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			try {
				String amountStr = textField.getText();
				

				Date date = new Date();

				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter amount to withdraw");
				} else {
					int amount = Integer.parseInt(amountStr);
					Conn connection = new Conn();
					ResultSet resultSet = connection.statement
							.executeQuery("select * from bank where pin = '" + pin + "'");
					int balance = 0;
					while (resultSet.next()) {
						/*
						 * if(resultSet.getString("type").equals("Deposite")) { balance +=
						 * Integer.parseInt(resultSet.getString("amount")); }else { balance -=
						 * Integer.parseInt(resultSet.getString("amount")); }
						 */
						balance = Integer.parseInt(resultSet.getString("amount"));
						if (balance < amount) {
							JOptionPane.showMessageDialog(null, "Insufficient Balance");
							return;
						}
						balance = balance - amount;
						System.out.println(balance);
						String q = "update bank set amount = '" + balance + "' where pin = '" + pin + "' ";
						System.out.println(q);
						connection.statement.executeUpdate(q);
						
						String query = "insert into withdrwal values('"+pin+"', '"+date+"','Withdrwal','"+amount+"')";
						System.out.println(query + amount);
						connection.statement.executeUpdate(query);
						System.out.println(query + amount);
						JOptionPane.showMessageDialog(null, "Amount Debited Rs. " + amount);
						new Main_Class(pin);
						setVisible(false);
						
						

					}

				

					// connection.statement.executeQuery("Update bank " + "set amount =
					// '"+balance+"'" + "where pin = '"+pin+"'");
					
				}
			} catch (Exception E) {

			}
		} else if (e.getSource() == b2) {
			new Main_Class(pin);
			setVisible(false);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdrwal("");
	}

}
