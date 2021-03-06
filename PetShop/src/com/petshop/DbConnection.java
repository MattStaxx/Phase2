package com.petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private Connection connection;
	
	// Constructor to initialize the values needed to gain access to the database
	public DbConnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);
	}

	public Connection getConnection() {

		return this.connection;
	}    //java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver

	public void closeConnection() throws SQLException {

		if(this.connection != null) {
			this.connection.close();
		}
	}
}
