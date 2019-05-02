package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.serviceimpl.CityServiceImpl;
import com.bus.reservation.serviceimpl.DatabaseServiceImpl;
import com.google.gson.Gson;




@WebServlet(urlPatterns = { "/getCityNameFromId"})
public class DatabaseController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cityId=request.getParameter("citiId");
		CityServiceImpl csi=new CityServiceImpl();
		String cityName=csi.getCityName(cityId);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> allCity=new HashMap<String, String>();
		allCity.put("CityName", cityName);
		String resultString=new Gson().toJson(allCity);
		out.print(resultString);
		out.flush();
	}
	
	
	
}
