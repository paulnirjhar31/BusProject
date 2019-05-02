package com.bus.reservation.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bus.reservation.models.BusStop;
import com.bus.reservation.models.RoutesDetails;

public class RouteServiceImple {
	
	public List<RoutesDetails> getAllRoutes() {		
		Connection connection=null;
		List<RoutesDetails> allRoutes=new ArrayList<RoutesDetails>();
		try {
			connection= DatabaseServiceImpl.getConnection();
			Statement st=connection.createStatement();			
			String query="select distinct idbusroute from busroute";			
			ResultSet rs=st.executeQuery(query);			
			
			while(rs.next()) {
				RoutesDetails rd=new RoutesDetails();
				rd.setRouteid(rs.getString(1));
				allRoutes.add(rd);
			}
			//next fill the bus stops for each route
			String busStopQuery="(select fromCity,(select cityname from city where cityid=fromCity) as fromcityname,  fare, timeinterval from busroute where idbusroute=vbusrouteid order by routeorder) union all (select toCity,(select cityname from city where cityid=toCity) as fromcityname, null, null from busroute where idbusroute=vbusrouteid and routeorder=(select max(routeorder) from busroute where idbusroute=vbusrouteid))";
			String queryToExecute="";
			for(int i=0;i<allRoutes.size();i++) {
				List<BusStop> busStopList=new ArrayList<BusStop>();
				queryToExecute=busStopQuery.replaceAll("vbusrouteid", allRoutes.get(i).getRouteid());
				rs=st.executeQuery(queryToExecute);
				while(rs.next()) {
					BusStop bs=new BusStop();
					bs.setCityId(rs.getString(1));
					bs.setCityName(rs.getString(2));
					bs.setFareToReachNextstation(rs.getString(3));
					bs.setTimeintervalToNextStation(rs.getString(4));
					busStopList.add(bs);
				}				
				allRoutes.get(i).setBusStops(busStopList);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DatabaseServiceImpl.closeConnection(connection);
		}
		
		return allRoutes;
	}

}
