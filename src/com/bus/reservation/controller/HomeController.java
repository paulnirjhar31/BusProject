package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.models.CityDetail;
import com.bus.reservation.serviceInterface.IHomePageService;
import com.bus.reservation.serviceimpl.HomePageService;
import com.google.gson.Gson;


@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet{

	
	IHomePageService iHomePageService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iHomePageService=new HomePageService(); 		
		Map<String, List<CityDetail>> allResult=new HashMap<String, List<CityDetail>>();
		allResult.put("SourceList", iHomePageService.getSourceList());
		allResult.put("DestinationList", iHomePageService.getSourceList());		
		String resultString=new Gson().toJson(allResult);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(resultString);
		out.flush();
		
	}
}
