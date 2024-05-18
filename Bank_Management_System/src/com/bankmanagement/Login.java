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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * ActionLister implemented for to perform actions executed by the buttons
 * 
 */
public class Login extends JFrame implements ActionListener {
	JLabel label1, label2, label3;
	JTextField jtextField2;
	JPasswordField jpasswordField3;
	JButton button1, button2, button3;

	Login() {
		super("Bank Management System");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(350, 10, 100, 100);
		add(image);

		ImageIcon card = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
		Image card1 = card.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon card2 = new ImageIcon(card1);
		JLabel card3 = new JLabel(card2);
		card3.setBounds(630, 350, 100, 100);

		add(card3);

		label1 = new JLabel("Welcome To ATM");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("AvantGrade", Font.BOLD, 38));
		label1.setBounds(230, 125, 450, 40);
		add(label1);

		label2 = new JLabel("Card No: ");
		label2.setFont(new Font("Ralway", Font.BOLD, 28));
		label2.setForeground(Color.WHITE);
		label2.setBounds(150, 190, 375, 30);
		add(label2);

		jtextField2 = new JTextField(15);
		jtextField2.setBounds(325, 190, 230, 30);
		jtextField2.setFont(new Font("Arial", Font.BOLD, 14));
		add(jtextField2);

		label3 = new JLabel("PIN: ");
		label3.setFont(new Font("Ralway", Font.BOLD, 28));
		label3.setForeground(Color.WHITE);
		label3.setBounds(150, 250, 375, 30);
		add(label3);

		jpasswordField3 = new JPasswordField(15);
		jpasswordField3.setFont(new Font("Atial", Font.BOLD, 14));
		jpasswordField3.setBounds(325, 250, 230, 30);
		add(jpasswordField3);

		button1 = new JButton("SIGN IN");
		button1.setFont(new Font("Arial", Font.BOLD, 14));
		button1.setForeground(Color.WHITE);
		button1.setBackground(Color.black);
		button1.setBounds(300, 300, 100, 30);
		button1.addActionListener(this);
		add(button1);

		button2 = new JButton("Clear");
		button2.setFont(new Font("Arial", Font.BOLD, 14));
		button2.setForeground(Color.WHITE);
		button2.setBackground(Color.BLACK);
		button2.setBounds(430, 300, 100, 30);
		button2.addActionListener(this);
		add(button2);

		button3 = new JButton("SIGN UP");
		button3.setFont(new Font("Arial", Font.BOLD, 14));
		button3.setForeground(Color.WHITE);
		button3.setBackground(Color.BLACK);
		button3.setBounds(300, 350, 230, 30);
		button3.addActionListener(this);
		add(button3);

		ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
		Image back1 = back.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon back2 = new ImageIcon(back1);
		JLabel back3 = new JLabel(back2);

		add(back3);

		// getContentPane().setBackground(new Color(222,255,228));
		// setLayout(null);

		setSize(850, 480);
		setUndecorated(true);
		setVisible(true);
		setLocation(450, 200);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getSource() == button1) {
				Conn connection = new Conn();
				String cardno = jtextField2.getText();
				System.out.println(cardno);
				String pinStr = jpasswordField3.getText();
				int pin = Integer.parseInt(pinStr);

				System.out.println(pin);

				String q = "select * from login where card_number = '" + cardno + "' and pin = '" + pin + "'";
				ResultSet resultSet = connection.statement.executeQuery(q);
				if (resultSet.next()) {
					setVisible(false);
					new Main_Class(pin);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card No or Password");
				}

			} else if (e.getSource() == button2) {
				jtextField2.setText("");
				jpasswordField3.setText("");
			} else if (e.getSource() == button3) {
				new Signup();
				setVisible(false);
			}

		} catch (Exception E) {
			// TODO: handle exception
			E.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new Login();
	}
}
