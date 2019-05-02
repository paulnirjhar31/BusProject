package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.models.CityDetail;
import com.bus.reservation.serviceimpl.CityServiceImpl;
import com.google.gson.Gson;


@WebServlet("/City")
public class CityController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityServiceImpl csi=new CityServiceImpl();
		List<CityDetail> allCity=csi.getAllCity();
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString=new Gson().toJson(allCity);
		out.print(resultString);
		out.flush();
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cityName=(String)request.getParameter("cityName");
		String cityType=(String)request.getParameter("cityType");
		String id=(String)request.getParameter("id");	
		String active=(String)request.getParameter("active");
		CityServiceImpl csi=new CityServiceImpl();
		if(id==null) {
			csi.addNewCity(cityName, cityType);
		} else {
			csi.updateCity(id, cityName, cityType, active);
		}
		
		Map<String, String> resultmap=new HashMap<>();
		resultmap.put("result", "success");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString=new Gson().toJson(resultmap);
		out.print(resultString);
		out.flush();
	}


	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityId=request.getParameter("cityId");
		System.out.println(cityId);
		CityServiceImpl csi=new CityServiceImpl();
		csi.deleteCity(cityId);		
		Map<String, String> resultmap=new HashMap<>();
		resultmap.put("result", "success");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString=new Gson().toJson(resultmap);
		out.print(resultString);
		out.flush();
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
	
	
	
	
}
