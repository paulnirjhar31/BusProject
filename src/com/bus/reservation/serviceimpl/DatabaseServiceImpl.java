package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServiceImpl {
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/testconfig?" + "user=nirjhar&password=password");

	}
    
    public static void closeConnection(Connection connection) {
    	if(connection !=null) {
    		try {
    			connection.close();
    		}catch(Exception e) {
    			System.out.println("connection alread closed");
    		}
    		
    	}
    }
    
}
