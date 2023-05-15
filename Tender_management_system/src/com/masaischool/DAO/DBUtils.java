package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBUtils {

	final static String URL;
	final static String Username;
	final static String Password;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.err.println("Fatal error");
			System.exit(1);
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("DBdetails");
		
		URL = rb.getString("url");
		Username = rb.getString("username");
		Password = rb.getString("password");

	}
	
	static Connection ConnectToDatabse()throws SQLException{
		return DriverManager.getConnection(URL,Username,Password);
	}

	static void closeConnection(Connection conn)throws SQLException{
		
		if(conn != null) {
			conn.close();
		}
		
	}
	
}
