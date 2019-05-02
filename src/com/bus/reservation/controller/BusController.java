package com.bus.reservation.controller;

import com.bus.reservation.models.BusDetails;
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

import com.bus.reservation.serviceimpl.BusServiceImpl;
import com.bus.reservation.serviceimpl.CityServiceImpl;
import com.google.gson.Gson;


@WebServlet("/BusController")
public class BusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busid=request.getParameter("busid");
		System.out.println(busid);
		BusServiceImpl bsi=new BusServiceImpl();
		bsi.deleteBus(busid);
		
		
		Map<String, String> resultmap=new HashMap<>();
		resultmap.put("result", "success");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString=new Gson().toJson(resultmap);
		out.print(resultString);
		out.flush();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusServiceImpl bsi = new BusServiceImpl();
		List<BusDetails> allBusses = bsi.getAllBusDetails();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString = new Gson().toJson(allBusses);
		out.print(resultString);
		out.flush();
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusServiceImpl bsi = new BusServiceImpl();
		String id=(String)request.getParameter("id");
		String companyname=request.getParameter("companyname");
		String make=request.getParameter("make");
		String type=request.getParameter("type");
		String arrivalTime=request.getParameter("arrivalTime");
		String routeid=request.getParameter("routeid");	
		String active=request.getParameter("active");	
		if(id==null) {
			//add a new bus since id is not there			
			bsi.createBus(companyname,make,type,arrivalTime,routeid);
		} else {
			bsi.updateBus(id,companyname,make,type,arrivalTime,routeid,active);
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

}
