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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
	String first = " " + Math.abs(first4);
	JTextField textName, textFname, textEmail, textAddress, textCity, textPin, textState;
	JDateChooser dateChooser;
	JRadioButton r1, r2, m1, m2, m3;
	JButton next;

	public Signup() {
		// TODO Auto-generated constructor stub
		super("Application Form");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(25, 10, 100, 100);
		add(image);

		JLabel label = new JLabel("APPLICATION FORM NUMBER " + first);
		label.setBounds(160, 20, 600, 40);
		label.setFont(new Font("Raleway", Font.BOLD, 28));
		add(label);

		JLabel label1 = new JLabel("Page 1");
		label1.setFont(new Font("Ralway", Font.BOLD, 22));
		label1.setBounds(370, 70, 600, 30);
		add(label1);

		JLabel label2 = new JLabel("Personal Details");
		label2.setFont(new Font("Ralway", Font.BOLD, 22));
		label2.setBounds(310, 100, 600, 30);
		add(label2);

		JLabel labelName = new JLabel("Name : ");
		labelName.setFont(new Font("Ralway", Font.BOLD, 20));
		labelName.setBounds(100, 190, 100, 30);
		add(labelName);

		textName = new JTextField();
		textName.setBounds(300, 190, 400, 30);
		textName.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textName);

		JLabel labelFName = new JLabel("Father's Name : ");
		labelFName.setFont(new Font("Ralway", Font.BOLD, 20));
		labelFName.setBounds(100, 240, 200, 30);
		add(labelFName);

		textFname = new JTextField();
		textFname.setBounds(300, 240, 400, 30);
		textFname.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textFname);

		JLabel DOB = new JLabel("Date of Birth : ");
		DOB.setFont(new Font("Ralway", Font.BOLD, 20));
		DOB.setBounds(100, 340, 200, 30);
		add(DOB);

		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(150, 105, 105));
		dateChooser.setBounds(300, 340, 400, 30);
		add(dateChooser);

		JLabel labelG = new JLabel("Gender : ");
		labelG.setFont(new Font("Ralway", Font.BOLD, 20));
		labelG.setBounds(100, 290, 200, 30);
		add(labelG);

		r1 = new JRadioButton("Male");
		r1.setBackground(new Color(222, 255, 228));
		r1.setFont(new Font("Ralway", Font.BOLD, 14));
		r1.setBounds(300, 290, 60, 30);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setBackground(new Color(222, 255, 228));

		r2.setFont(new Font("Ralway", Font.BOLD, 14));
		r2.setBounds(450, 290, 90, 30);
		add(r2);

		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);

		JLabel labelEmail = new JLabel("Email : ");
		labelEmail.setFont(new Font("Ralway", Font.BOLD, 20));
		labelEmail.setBounds(100, 390, 200, 30);
		add(labelEmail);

		textEmail = new JTextField();
		textEmail.setBounds(300, 390, 400, 30);
		textEmail.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textEmail);

		JLabel labelStatus = new JLabel("Marital Status : ");
		labelStatus.setFont(new Font("Ralway", Font.BOLD, 20));
		labelStatus.setBounds(100, 440, 200, 30);
		add(labelStatus);

		m1 = new JRadioButton("Married");
		m1.setBackground(new Color(222, 255, 228));
		m1.setFont(new Font("Ralway", Font.BOLD, 14));
		m1.setBounds(300, 440, 100, 30);
		add(m1);

		m2 = new JRadioButton("Unmarried");
		m2.setBackground(new Color(222, 255, 228));
		m2.setFont(new Font("Ralway", Font.BOLD, 14));
		m2.setBounds(450, 440, 100, 30);
		add(m2);

		m3 = new JRadioButton("Other");
		m3.setBackground(new Color(222, 255, 228));
		m3.setFont(new Font("Ralway", Font.BOLD, 14));
		m3.setBounds(635, 440, 100, 30);
		add(m3);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(m1);
		btnGroup.add(m2);
		btnGroup.add(m3);

		JLabel labelAddress = new JLabel("Address : ");
		labelAddress.setFont(new Font("Ralway", Font.BOLD, 20));
		labelAddress.setBounds(100, 490, 200, 30);
		add(labelAddress);

		textAddress = new JTextField();
		textAddress.setBounds(300, 490, 400, 30);
		textAddress.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textAddress);

		JLabel labelCity = new JLabel("City : ");
		labelCity.setFont(new Font("Ralway", Font.BOLD, 20));
		labelCity.setBounds(100, 540, 200, 30);
		add(labelCity);

		textCity = new JTextField();
		textCity.setBounds(300, 540, 400, 30);
		textCity.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textCity);

		JLabel labelPin = new JLabel("Pin Code : ");
		labelPin.setFont(new Font("Ralway", Font.BOLD, 20));
		labelPin.setBounds(100, 590, 200, 30);
		add(labelPin);

		textPin = new JTextField();
		textPin.setBounds(300, 590, 400, 30);
		textPin.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textPin);

		JLabel labelState = new JLabel("State : ");
		labelState.setFont(new Font("Ralway", Font.BOLD, 20));
		labelState.setBounds(100, 640, 200, 30);
		add(labelState);

		textState = new JTextField();
		textState.setBounds(300, 640, 400, 30);
		textState.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textState);

		next = new JButton("Next");
		next.setFont(new Font("Ralway", Font.BOLD, 14));
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.setBounds(620, 710, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(new Color(222, 255, 228));
		setLayout(null);
		setSize(850, 800);
		setLocation(360, 40);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String formNo = first;
		String name = textName.getText();
		String fname = textFname.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (r1.isSelected()) {
			gender = "Male";
		} else if (r2.isSelected()) {
			gender = "Female";
		}
		String email = textEmail.getText();
		String mStatus = null;
		if (m1.isSelected())
			mStatus = "Married";
		else if (m2.isSelected())
			mStatus = "Unmarried";
		else if (m3.isSelected())
			mStatus = "Other";
		String address = textAddress.getText();
		String city = textCity.getText();
		String pin = textPin.getText();
		String state = textState.getText();

		try {
			if (textName.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please Enter Name ");
			else {

				Conn connection = new Conn();
				String query = "insert into signup values('" + formNo + "', '" + name + "', '" + fname + "' , '" + dob
						+ "', '" + gender + "', '" + email + "', '" + mStatus + "', '" + address + "', '" + city
						+ "', '" + pin + "', '" + state + "')";
				connection.statement.executeUpdate(query);
				new Signup2(formNo);
				setVisible(false);
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup();
	}

}
