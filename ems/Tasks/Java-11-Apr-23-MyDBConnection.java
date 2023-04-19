package com.dal.helper;

import java.sql.*;

public class MyDBConnection {
	public static Connection GetConnection() {
		Connection con = null;
		try {
			// Load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Create the connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba", "orbis");
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		}
		catch(ClassNotFoundException ex2)
		{
			ex2.printStackTrace();
		}
		return con;
	}
}
