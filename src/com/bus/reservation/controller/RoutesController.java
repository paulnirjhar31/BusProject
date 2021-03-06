package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.models.RoutesDetails;
import com.bus.reservation.serviceimpl.RouteServiceImple;
import com.google.gson.Gson;

/**
 * Servlet implementation class RoutesController
 */
@WebServlet("/RoutesController")
public class RoutesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RouteServiceImple rsi=new RouteServiceImple();
		List<RoutesDetails> allRoutes=rsi.getAllRoutes();
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String resultString=new Gson().toJson(allRoutes);
		out.print(resultString);
		out.flush();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
