package com.jbk.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {
		Connection connection = null;
	
		try {
		
			// 1. load driver	
			Class.forName("com.mysql.jdbc.Driver");
			
			// make connection 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
