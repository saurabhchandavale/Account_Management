package com.bankmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection connection;
	Statement statement;
	
	public Conn() {
		
		try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "System@15");
		statement = connection.createStatement();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
