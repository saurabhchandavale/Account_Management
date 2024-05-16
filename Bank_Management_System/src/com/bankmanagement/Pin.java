package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener {
	JButton b1, b2;
	JPasswordField p1, p2;
	String pin;

	public Pin(String pin) {
		super("Change Pin");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 1550, 830);
		add(image);

		this.pin = pin;
		JLabel label1 = new JLabel("Change Your Pin ");
		label1.setFont(new Font("System", Font.BOLD, 16));
		label1.setBounds(430, 180, 400, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		JLabel label2 = new JLabel("New Pin");
		label2.setFont(new Font("System", Font.BOLD, 16));
		label2.setBounds(430, 220, 400, 35);
		label2.setForeground(Color.WHITE);
		image.add(label2);

		p1 = new JPasswordField();
		p1.setBackground(new Color(65, 125, 128));
		p1.setBounds(430, 250, 200, 35);
		p1.setFont(new Font("Ralway", Font.BOLD, 22));
		p1.setForeground(Color.WHITE);
		image.add(p1);

		JLabel label3 = new JLabel("Re-Enter Pin");
		label3.setFont(new Font("System", Font.BOLD, 16));
		label3.setBounds(430, 280, 400, 35);
		label3.setForeground(Color.WHITE);
		image.add(label3);

		p2 = new JPasswordField();
		p2.setBackground(new Color(65, 125, 128));
		p2.setBounds(430, 310, 200, 35);
		p2.setFont(new Font("Ralway", Font.BOLD, 22));
		p2.setForeground(Color.WHITE);
		image.add(p2);

		b1 = new JButton("Change Pin");
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

		String pin1 = p1.getText();
		String pin2 = p2.getText();

		try {

			if (e.getSource() == b1) {
				if (!pin1.equals(pin2)) {
					JOptionPane.showMessageDialog(null, "Password doesnt match..!");
					return;
				}

				if (p1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Password...!");
					return;
				}

				if (p2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Password...!");
					return;
				}

				Conn connection = new Conn();
				String q = "update bank set pin = '" + pin1 + "' where pin = '" + pin + "' ";
				String q1 = "update login set pin = '" + pin1 + "' where pin = '" + pin + "' ";
				String q2 = "update signupthree set pin = '" + pin1 + "' where pin = '" + pin + "' ";

				connection.statement.executeUpdate(q);
				connection.statement.executeUpdate(q1);

				connection.statement.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "Pin changed successfully....!");
				setVisible(false);
				new Main_Class(pin1);

			} else if (e.getSource() == b2) {
				new Main_Class(pin);
				setVisible(false);
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pin("");
	}

}
