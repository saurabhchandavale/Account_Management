package com.bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {
	String formno;
	JTextField textPan, textAdhar;
	JComboBox combox, combox1, combox2, combox3, combox4;
	JRadioButton r1, r2, e1, e2;
	JButton next;

	public Signup2(String formNo) {

		super("Application Form");
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
		Image i1 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(100, 5, 100, 100);
		add(image);

		this.formno = formNo;

		JLabel label1 = new JLabel("Page 2: ");
		label1.setFont(new Font("Ralway", Font.BOLD, 22));
		label1.setBounds(370, 50, 600, 40);
		add(label1);

		JLabel label2 = new JLabel("Additional Details");
		label2.setFont(new Font("Ralway", Font.BOLD, 22));
		label2.setBounds(310, 80, 600, 30);
		add(label2);

		JLabel labelReligion = new JLabel("Religion : ");
		labelReligion.setFont(new Font("Ralway", Font.BOLD, 20));
		labelReligion.setBounds(100, 120, 100, 30);
		add(labelReligion);

		String religion[] = { "Hindu", "Muslim", "Sikh", "Other" };
		combox = new JComboBox(religion);
		combox.setFont(new Font("Ralway", Font.BOLD, 14));
		combox.setBounds(350, 120, 320, 30);
		combox.setBackground(new Color(252, 208, 76));
		add(combox);

		JLabel labelCategory = new JLabel("Category : ");
		labelCategory.setFont(new Font("Ralway", Font.BOLD, 20));
		labelCategory.setBounds(100, 170, 120, 30);
		add(labelCategory);

		String category[] = { "General", "OBC", "SC", "Other" };
		combox1 = new JComboBox(category);
		combox1.setFont(new Font("Ralway", Font.BOLD, 14));
		combox1.setBounds(350, 170, 320, 30);
		combox1.setBackground(new Color(252, 208, 76));
		add(combox1);

		JLabel labelIncome = new JLabel("Income : ");
		labelIncome.setFont(new Font("Ralway", Font.BOLD, 20));
		labelIncome.setBounds(100, 220, 120, 30);
		add(labelIncome);

		String income[] = { "Null", "< 1,50,000", "< 5,00,000", "Other" };
		combox2 = new JComboBox(income);
		combox2.setFont(new Font("Ralway", Font.BOLD, 14));
		combox2.setBounds(350, 220, 320, 30);
		combox2.setBackground(new Color(252, 208, 76));
		add(combox2);

		JLabel labelEduction = new JLabel("Eduction : ");
		labelEduction.setFont(new Font("Ralway", Font.BOLD, 20));
		labelEduction.setBounds(100, 270, 120, 30);
		add(labelEduction);

		String eduction[] = { "Graduate", "Non Graduate", "Laywer", "Other" };
		combox3 = new JComboBox(eduction);
		combox3.setFont(new Font("Ralway", Font.BOLD, 14));
		combox3.setBounds(350, 270, 320, 30);
		combox3.setBackground(new Color(252, 208, 76));
		add(combox3);

		JLabel labelOccuption = new JLabel("Occuption : ");
		labelOccuption.setFont(new Font("Ralway", Font.BOLD, 20));
		labelOccuption.setBounds(100, 320, 120, 30);
		add(labelOccuption);

		String occuption[] = { "Student", "Saliried", "Bussiness", "Other" };
		combox4 = new JComboBox(occuption);
		combox4.setFont(new Font("Ralway", Font.BOLD, 14));
		combox4.setBounds(350, 320, 320, 30);
		combox4.setBackground(new Color(252, 208, 76));
		add(combox4);

		JLabel labelPan = new JLabel("Pan Number : ");
		labelPan.setFont(new Font("Ralway", Font.BOLD, 18));
		labelPan.setBounds(100, 370, 160, 30);
		add(labelPan);

		textPan = new JTextField();
		textPan.setBounds(350, 370, 320, 30);
		textPan.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textPan);

		JLabel labelAdhar = new JLabel("Adhar Number : ");
		labelAdhar.setFont(new Font("Ralway", Font.BOLD, 18));
		labelAdhar.setBounds(100, 420, 160, 30);
		add(labelAdhar);

		textAdhar = new JTextField();
		textAdhar.setBounds(350, 420, 320, 30);
		textAdhar.setFont(new Font("Ralway", Font.BOLD, 14));
		add(textAdhar);

		JLabel labelCitizen = new JLabel("Senior Citizen : ");
		labelCitizen.setFont(new Font("Ralway", Font.BOLD, 18));
		labelCitizen.setBounds(100, 470, 160, 30);
		add(labelCitizen);

		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Ralway", Font.BOLD, 14));
		r1.setBounds(350, 470, 100, 30);
		r1.setBackground(new Color(252, 208, 76));
		add(r1);

		r2 = new JRadioButton("No");
		r2.setFont(new Font("Ralway", Font.BOLD, 14));
		r2.setBounds(450, 470, 100, 30);
		r2.setBackground(new Color(252, 208, 76));
		add(r2);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(r1);
		btnGroup.add(r2);

		JLabel labelExisting = new JLabel("Existing Account : ");
		labelExisting.setFont(new Font("Ralway", Font.BOLD, 18));
		labelExisting.setBounds(100, 520, 200, 30);
		add(labelExisting);

		e1 = new JRadioButton("Yes");
		e1.setFont(new Font("Ralway", Font.BOLD, 14));
		e1.setBounds(350, 520, 100, 30);
		e1.setBackground(new Color(252, 208, 76));
		add(e1);

		e2 = new JRadioButton("No");
		e2.setFont(new Font("Ralway", Font.BOLD, 14));
		e2.setBounds(450, 520, 100, 30);
		e2.setBackground(new Color(252, 208, 76));
		add(e2);

		ButtonGroup group = new ButtonGroup();
		group.add(e1);
		group.add(e2);

		JLabel labelForm = new JLabel("Form No : ");
		labelForm.setFont(new Font("Ralway", Font.BOLD, 18));
		labelForm.setBounds(600, 10, 100, 30);
		add(labelForm);

		JLabel labelform = new JLabel(formno);
		labelform.setFont(new Font("Ralway", Font.BOLD, 18));
		labelform.setBounds(760, 10, 100, 30);
		add(labelform);

		next = new JButton("Next");
		next.setFont(new Font("Ralway", Font.BOLD, 14));
		next.setBounds(570, 640, 100, 30);
		next.setBackground(Color.white);
		next.setForeground(Color.BLACK);
		next.addActionListener(this);
		add(next);

		setLayout(null);
		getContentPane().setBackground(new Color(252, 208, 76));
		setSize(850, 750);
		setLocation(360, 40);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String rel = (String) combox.getSelectedItem();
		String category = (String) combox1.getSelectedItem();
		String income = (String) combox2.getSelectedItem();
		String education = (String) combox3.getSelectedItem();
		String occupation = (String) combox4.getSelectedItem();

		String pan = textPan.getText();
		String addhar = textAdhar.getText();

		String citizen = " ";
		if (r1.isSelected())
			citizen = "YES";
		else if (r2.isSelected())
			citizen = "NO";

		String existing = " ";
		if (e1.isSelected())
			existing = "YES";
		else if (e2.isSelected())
			existing = "NO";

		try {
			if (textPan.getText().equals("") || textAdhar.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please Enter Pan and Addhar Number ");

			else {

				Conn connection = new Conn();
				String query = "insert into signuptwo values('" + formno + "', '" + rel + "', '" + category + "', '" + income + "' , '"
						+ education + "', '" + occupation + "', '" + pan + "', '" + addhar + "', '" + citizen + "', '"
						+ existing + "')";
				connection.statement.executeUpdate(query);
				new Signup3(formno);
				setVisible(false);
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new Signup2("  ");
	}
}
