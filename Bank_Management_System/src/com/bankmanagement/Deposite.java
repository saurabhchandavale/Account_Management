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
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener {
	String pin;
	TextField textField;
	JButton b1, b2;

	public Deposite(String pin) {
		super("Deposite ");
		this.pin = pin;

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 1550, 830);
		add(image);

		JLabel label1 = new JLabel("Enter amount you want to deposite ");
		label1.setFont(new Font("System", Font.BOLD, 16));
		label1.setBounds(460, 180, 400, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		textField = new TextField();
		textField.setBackground(new Color(65, 125, 128));
		textField.setBounds(460, 230, 320, 25);
		textField.setFont(new Font("Ralway", Font.BOLD, 22));
		textField.setForeground(Color.WHITE);
		image.add(textField);

		b1 = new JButton("Deposite");
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

		try {
			String amountStr = textField.getText();
		
		
			Date date = new Date();
			int existing = 0;
			if (e.getSource() == b1) {
				if (amountStr.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter amout want to deposite");
				} else {
					int amount = Integer.parseInt(amountStr);
					Conn connection = new Conn();
					String deposite = "insert into deposite values('" + pin + "', '" + date + "','Deposite', '" + amount + "' )";
					connection.statement.executeUpdate(deposite);
					String query = "select amount from bank where pin = '"+pin+"'";
					ResultSet resultSet = connection.statement.executeQuery(query);
					if(resultSet.next()) {
						existing = Integer.parseInt(resultSet.getString("amount"));
						
					}
					if(existing > 0) {
						existing = existing + amount;
						String updateAccount = "update bank set amount = '" + existing + "' where pin = '" + pin + "' ";
						//String q = "update bank set amount = '" + existing + "' where pin = '" + pin + "' ";
						connection.statement.executeUpdate(updateAccount);
						System.out.println(updateAccount);
						new Main_Class(pin);
					}else {
				//	existing = existing + amount;
					String q = "insert into bank values('" + pin + "', '" + date + "','Current', '" + amount + "' )";
					connection.statement.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited in your account");
					setVisible(false);
					new Main_Class(pin);
					}

				}

			} else if (e.getSource() == b2) {
				new Main_Class(pin);
				setVisible(false);
				
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new Deposite("");
	}
}
