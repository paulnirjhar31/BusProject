package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bus.reservation.models.UserDetails;

public class LoginServiceImpl {

	public boolean checkLoginOtp(String lemailmobile, String password) {
		Connection connection=null;		
		try {
			connection=DatabaseServiceImpl.getConnection();
			String query="select * from otptable where mobile='"+lemailmobile+"' and otp='"+password+"' and valid='Y'";
			System.out.println(query);
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				
				System.out.println("value here ----------");
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return false;
		
	}

	public UserDetails getUserDetailsByMobile(String lemailmobile) {
		Connection connection=null;		
		UserDetails ud=new UserDetails();
		try {
			connection=DatabaseServiceImpl.getConnection();
			String query="select * from users where mobile='"+lemailmobile+"' and active='Y'";
			System.out.println(query);
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				ud.setEmail(rs.getString("email"));
				ud.setMobile(rs.getString("mobile"));
				ud.setName(rs.getString("name"));
				ud.setType(rs.getString("type"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
		System.out.println(ud);
		return ud;
	}

	public void updateOtpTable(String lemailmobile) {
		Connection connection=null;	
		
		try {
			connection=DatabaseServiceImpl.getConnection();
			String query="update otptable set valid='F' where mobile='"+lemailmobile+"'";
			Statement st=connection.createStatement();
			st.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
	}

	public UserDetails checkLoginPassword(String lemailmobile, String password) {
		
		Connection connection=null;
		UserDetails ud=null;
		try {
			connection=DatabaseServiceImpl.getConnection();
			String query="select * from users where (mobile='"+lemailmobile+"' or email='"+lemailmobile+"') and password='"+password+"' and active='Y'";
			System.out.println(query);
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				ud=new UserDetails();
				ud.setEmail(rs.getString("email"));
				ud.setMobile(rs.getString("mobile"));
				ud.setName(rs.getString("name"));
				ud.setType(rs.getString("type"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
		return ud;
		
	}

}
