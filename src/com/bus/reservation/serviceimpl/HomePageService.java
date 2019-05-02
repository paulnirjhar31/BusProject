package com.bus.reservation.serviceimpl;


import com.bus.reservation.models.CityDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.bus.reservation.serviceInterface.IHomePageService;

public class HomePageService implements IHomePageService {

	@Override
	public List<CityDetail> getSourceList() {
		Connection con = null;
		List<CityDetail> cityList=new ArrayList<CityDetail>();
		try {
			con = DatabaseServiceImpl.getConnection();
			Statement st = con.createStatement();
			String query = "select CityId, CityName from City";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				CityDetail cd=new CityDetail();
				cd.setId(rs.getInt(1)+"");
				cd.setCityName(rs.getString(2));
				cityList.add(cd);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseServiceImpl.closeConnection(con);
		}
		return cityList;

	}

}
