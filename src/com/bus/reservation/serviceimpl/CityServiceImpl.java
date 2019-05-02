package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bus.reservation.models.CityDetail;

public class CityServiceImpl {

	public String getCityName(String cityId) {
		Connection connection = null;
		String cityName = "";

		String query = "select CityName from city where CityId=" + cityId;
		System.out.println(query);
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				cityName = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return cityName;
	}

	public List<CityDetail> getAllCity() {
		
		Connection connection = null;
		ArrayList<CityDetail> allCities= new ArrayList<CityDetail>();
		try {
			connection = DatabaseServiceImpl.getConnection();
			String query="select * from city";
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				CityDetail cd=new CityDetail();
				cd.setActive(rs.getString("Active"));
				cd.setCityName(rs.getString("CityName"));
				cd.setCityType(rs.getString("CityType"));
				cd.setId(rs.getString("CityId"));
				allCities.add(cd);
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
		return allCities;
	}

	public int addNewCity(String cityName, String cityType) {
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			String idQuery="select IFNULL(max(CityId), 0)+1 from city";
			ResultSet rs=st.executeQuery(idQuery);
			int id=0;			
			while(rs.next()) {
				id=rs.getInt(1);
			}
			id=id+1;			
			String query="insert into city(CityId, CityName, CityType, Active) values ("+id+",'"+cityName+"','"+cityType+"','Y')";
			System.out.println(query);
			st.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return 1;
	}

	public void deleteCity(String cityId) {
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			String query="update city set active='F' where cityid="+cityId;
			st.execute(query);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
	}

	public void updateCity(String id, String cityName, String cityType, String active) {
		String query="update city set CityName='"+cityName+"', cityType='"+cityType+"', active='"+active+"' where cityid="+id;
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			st.execute(query);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
	}
	
}
