package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bus.reservation.models.BusDetails;
import com.bus.reservation.models.PassengerDetail;

public class BusServiceImpl {

	public List<BusDetails> getAllBusDetails() {
		String sql = "select * from busdetails";

		List<BusDetails> allBusses = new ArrayList<BusDetails>();
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				BusDetails bd = new BusDetails();
				bd.setBusid(rs.getString("BusDetailid"));
				bd.setCompanyName(rs.getString("CompanyName"));
				bd.setMake(rs.getString("Make"));
				bd.setType(rs.getString("Type"));
				bd.setBaseFare(rs.getString("BusFareBase"));
				bd.setRouteId(rs.getString("BusRouteId"));
				bd.setArriveTime(rs.getString("ArivalTime"));
				bd.setActive(rs.getString("Active"));
				allBusses.add(bd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return allBusses;
	}

	public BusDetails getBusDetails(String busid, String fromCity, String toCity) {
		String query = "select * from busdetails where BusDetailid=" + busid;
		Connection connection = null;
		BusDetails bd = new BusDetails();

		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				bd.setBusid(rs.getString("BusDetailid"));
				bd.setCompanyName(rs.getString("CompanyName"));
				bd.setDepartingTime(rs.getString("ArivalTime"));
				bd.setMake(rs.getString("Make"));
				bd.setType(rs.getString("Type"));
				bd.setBaseFare(rs.getString("BusFareBase"));
				bd.setRouteId(rs.getString("BusRouteId"));

				String query1 = "select * from busroute where idBusRoute=" + bd.getRouteId();
				Statement st1 = connection.createStatement();
				ResultSet rs1 = st1.executeQuery(query1);
				int interval = 0;
				boolean startAdd = false;
				while (rs1.next()) {
					if (rs1.getString("fromCity").equalsIgnoreCase(fromCity)) {
						startAdd = true;
					}
					if (startAdd) {
						try {
							interval = interval + Integer.parseInt(rs1.getString("timeInterval"));
							if (rs1.getString("toCity").equalsIgnoreCase(toCity)) {
								startAdd = false;
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				bd.setTotalDistance("" + interval);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return bd;
	}

	public List<BusDetails> getAllAvailableBusses(String fromCity, String toCity) {

		List<BusDetails> allAvailableBusses = new ArrayList<BusDetails>();

		String query = "select * from busdetails where busrouteid in (select idBusRoute from busroute where idBusRoute in (select idBusRoute from busroute where fromCity="
				+ fromCity + " and active='Y') and toCity=" + toCity + " and active = 'Y')";
		Connection connection = null;

		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				BusDetails bd = new BusDetails();

				// set the variables
				bd.setBusid(rs.getString("BusDetailid"));
				bd.setCompanyName(rs.getString("CompanyName"));
				bd.setDepartingTime(rs.getString("ArivalTime"));
				bd.setMake(rs.getString("Make"));
				bd.setType(rs.getString("Type"));
				bd.setBaseFare(rs.getString("BusFareBase"));
				bd.setRouteId(rs.getString("BusRouteId"));

				String query1 = "select * from busroute where idBusRoute=" + bd.getRouteId();
				Statement st1 = connection.createStatement();
				ResultSet rs1 = st1.executeQuery(query1);
				int interval = 0;
				boolean startAdd = false;
				while (rs1.next()) {
					if (rs1.getString("fromCity").equalsIgnoreCase(fromCity)) {
						startAdd = true;
					}
					if (startAdd) {
						try {
							interval = interval + Integer.parseInt(rs1.getString("timeInterval"));
							if (rs1.getString("toCity").equalsIgnoreCase(toCity)) {
								startAdd = false;
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}

				bd.setTotalDistance("" + interval);

				allAvailableBusses.add(bd);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}

		return allAvailableBusses;
	}

	public void saveBookingInformation(ArrayList<PassengerDetail> allPassenger, String busId, String fromCity,
			String toCity, String startDate, String endDate, String bookingMailid, String bookingMobileNumber) {

		System.out.println("----------------adding booking information to db--------------------");
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();

			String idQuery = "select IFNULL(max(id), 0)+1 from reservedseatinformation";
			ResultSet rs = st.executeQuery(idQuery);
			int id = 0;

			while (rs.next()) {
				id = rs.getInt(1);
			}
			for (PassengerDetail pd : allPassenger) {
				id++;
				String query = "insert into reservedseatinformation values(" + id + ",'" + busId + "','0'," + "'"
						+ fromCity + "','" + toCity + "','" + bookingMailid + "','" + bookingMobileNumber + "','"
						+ pd.getName() + "','" + pd.getAge() + "','" + pd.getGender() + "','" + startDate + "','"
						+ pd.getSeatNumber() + "')";

				System.out.println(query);
				st.execute(query);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}

	}

	public String findBookedSeat(String busId, String date) {
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st = connection.createStatement();
			String query = "SELECT seatnumber FROM reservedseatinformation where busid=" + busId + " and date='" + date
					+ "'";
			ResultSet rs = st.executeQuery(query);
			List<String> allSeat = new ArrayList<String>();
			while (rs.next()) {
				allSeat.add(rs.getString(1));
			}
			String idList = allSeat.toString();
			String csv = idList.substring(1, idList.length() - 1).replace(", ", ",");
			return csv;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return "";

	}

	public void deleteBus(String busid) {
		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			String query="update busdetails set active='F' where BusDetailid="+busid;
			st.execute(query);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
	}

	public int createBus(String companyname, String make, String type, String arrivalTime, String routeid) {

		Connection connection = null;
		try {
			connection = DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			String idQuery="select IFNULL(max(BusDetailid), 0) from busdetails";
			ResultSet rs=st.executeQuery(idQuery);
			int id=0;			
			while(rs.next()) {
				id=rs.getInt(1);
			}
			id=id+1;			
			String query="insert into busdetails(BusDetailid, CompanyName, Make, Type, BusFareBase, BusRouteId, Active, ArivalTime) values ("+id+",'"+companyname+"','"+make+"','"+type+"','50','"+routeid+"','Y','"+arrivalTime+"')";
			System.out.println(query);
			st.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		return 1;		
	}

	public void updateBus(String id, String companyname, String make, String type, String arrivalTime, String routeid,
			String active) {
		String query="update busdetails set CompanyName='"+companyname+"', Make='"+make+"', Type='"+type+"',ArivalTime='"+arrivalTime+"', BusRouteId='"+routeid+"',active='"+active+"'  where BusDetailid="+id;
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
