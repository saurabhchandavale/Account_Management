package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5, b6, b7;
	int pin;

	public FastCash(int pin) {

		super("Fast Cash");
		this.pin = pin;
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 1550, 830);
		add(image);

		JLabel label1 = new JLabel("Select Withdrwal Amount ");
		label1.setFont(new Font("System", Font.BOLD, 28));
		label1.setBounds(430, 180, 700, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		b1 = new JButton("Rs. 100");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBounds(410, 274, 180, 35);
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(65, 125, 128));
		b1.addActionListener(this);

		image.add(b1);

		b2 = new JButton("Rs. 500");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBounds(670, 274, 180, 35);
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(65, 125, 128));
		b2.addActionListener(this);

		image.add(b2);

		b3 = new JButton("Rs. 1000");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBounds(410, 318, 180, 35);
		b3.setForeground(Color.WHITE);
		b3.setBackground(new Color(65, 125, 128));
		b3.addActionListener(this);

		image.add(b3);

		b4 = new JButton("Rs. 2000");
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBounds(670, 318, 180, 35);
		b4.setForeground(Color.WHITE);
		b4.setBackground(new Color(65, 125, 128));
		b4.addActionListener(this);

		image.add(b4);

		b5 = new JButton("Rs. 5000");
		b5.setFont(new Font("System", Font.BOLD, 18));
		b5.setBounds(410, 362, 180, 35);
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(65, 125, 128));
		b5.addActionListener(this);

		image.add(b5);

		b6 = new JButton("Rs. 10000");
		b6.setFont(new Font("System", Font.BOLD, 18));
		b6.setBounds(670, 362, 180, 35);
		b6.setForeground(Color.WHITE);
		b6.setBackground(new Color(65, 125, 128));
		b6.addActionListener(this);

		image.add(b6);

		b7 = new JButton("Exit ");
		b7.setFont(new Font("System", Font.BOLD, 18));
		b7.setBounds(670, 406, 180, 35);
		b7.setForeground(Color.WHITE);
		b7.setBackground(new Color(65, 125, 128));
		b7.addActionListener(this);
		image.add(b7);

		setLayout(null);
		getContentPane().setBackground(new Color(252, 208, 76));
		setSize(1550, 1080);
		setLocation(0, 0);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b7) {
			setVisible(false);
			new Main_Class(pin);
		} else {
			String amountStr = ((JButton) e.getSource()).getText().substring(4);
			Conn connection = new Conn();
			Date date = new Date();
			try {
				int amount = Integer.parseInt(amountStr);

				ResultSet resultSet = connection.statement.executeQuery("select * from bank where pin = '" + pin + "'");
				int balance = 0;
				while (resultSet.next()) {
					/*if (resultSet.getString("type").equals("Deposite")) {
						balance += Integer.parseInt(resultSet.getString("amount"));
					} else {
						balance -= Integer.parseInt(resultSet.getString("amount"));

					}*/
					balance = Integer.parseInt(resultSet.getString("amount"));
					System.out.println(balance);
				}
				

				if ( balance < amount) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}
				if(balance > amount) {
				balance = balance - amount; 
				String updateAccount = "update bank set amount = '" + balance + "' where pin = '" + pin + "' ";
				
				//String q = "update bank set amount = '" + existing + "' where pin = '" + pin + "' ";
				System.out.println("updateAccount " + updateAccount);
				connection.statement.executeUpdate(updateAccount);
				
				String with = "insert into withdrwal values('" + pin + "','" + date + "','Withdrwal','" + amount + "')";
				connection.statement.executeUpdate(with
						);
				System.out.println("with " + with);

				JOptionPane.showMessageDialog(null, "Amount Debited Rs " + amount);
				}

			} catch (Exception E) {
				E.printStackTrace();
			}
			
			setVisible(false);
			new Main_Class(pin);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		new FastCash(0);
	}

}
