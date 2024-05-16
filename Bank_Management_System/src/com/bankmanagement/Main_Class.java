package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Class extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;

	public Main_Class(String pin) {
		super("Transaction");
		this.pin = pin;
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
		Image i1 = i.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 1550, 830);
		add(image);

		JLabel label1 = new JLabel("Please select your transaction ");
		label1.setFont(new Font("System", Font.BOLD, 28));
		label1.setBounds(430, 180, 700, 35);
		label1.setForeground(Color.WHITE);
		image.add(label1);

		b1 = new JButton("Deposite");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBounds(410, 274, 180, 35);
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(65, 125, 128));
		b1.addActionListener(this);

		image.add(b1);

		b2 = new JButton("Cash Withdrawal");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBounds(670, 274, 180, 35);
		b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(65, 125, 128));
		b2.addActionListener(this);

		image.add(b2);

		b3 = new JButton("Fast Cash ");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBounds(410, 318, 180, 35);
		b3.setForeground(Color.WHITE);
		b3.setBackground(new Color(65, 125, 128));
		b3.addActionListener(this);

		image.add(b3);

		b4 = new JButton("Mini Statement");
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBounds(670, 318, 180, 35);
		b4.setForeground(Color.WHITE);
		b4.setBackground(new Color(65, 125, 128));
		b4.addActionListener(this);

		image.add(b4);

		b5 = new JButton("Pin Change ");
		b5.setFont(new Font("System", Font.BOLD, 18));
		b5.setBounds(410, 362, 180, 35);
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(65, 125, 128));
		b5.addActionListener(this);

		image.add(b5);

		b6 = new JButton("Balance Enquiry");
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
		if (e.getSource() == b1) {
			new Deposite(pin);
			setVisible(false);
		} else if (e.getSource() == b7) {
			System.exit(0);
		}else if(e.getSource() == b2) {
			new Withdrwal(pin);
			setVisible(false);
		}else if(e.getSource()== b6) {
			new BalanceEnquiry(pin);
			setVisible(false);
		}else if(e.getSource() == b3) {
			new FastCash(pin);
			setVisible(false);
		}else if(e.getSource() == b5) {
			new Pin(pin);
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_Class("");
	}

}
