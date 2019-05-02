package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationLoginServiceImpl {

	public boolean doRegister(String name, String email, String mobile, String password, String type, String active) {
		Connection connection=null;
		
		try {
			connection= DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();
			
			String idQuery="select IFNULL(max(id), 0)+1 from users";
			ResultSet rs=st.executeQuery(idQuery);
			int id=0;
			
			while(rs.next()) {
				id=rs.getInt(1);
			}
			id=id+1;
			String query="insert into users(id, name, email, mobile, password, type, active) "
					+ "values("+id+",'"+name+"','"+email+"','"+mobile+"','"+password+"','"+type+"','Y')";
			st.execute(query);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return false;
	}

	public boolean saveOtp(String mobile, String otp) {
		Connection connection = null;

		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			String idQuery = "select IFNULL(max(id), 0)+1 from otptable";
			ResultSet rs = st.executeQuery(idQuery);
			int id = 0;

			while (rs.next()) {
				id = rs.getInt(1);
			}
			id = id + 1;
			String query = "insert into otptable(id, mobile, otp, valid) values (" + id + ",'" + mobile + "','" + otp
					+ "','Y')";
			return st.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return false;
	}
	
}
