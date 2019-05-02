package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.serviceimpl.BusServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class SeatBookedFinder
 */
@WebServlet("/SeatBookedFinder")
public class SeatBookedFinder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatBookedFinder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busId=request.getParameter("busid");
		String date=request.getParameter("date");
		
		System.out.println(busId+"-----------------"+date );
		
		BusServiceImpl bipl=new BusServiceImpl();
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> allCity=new HashMap<String, String>();
		allCity.put("BookedSeat", bipl.findBookedSeat(busId, date));
		String resultString=new Gson().toJson(allCity);
		out.print(resultString);
		out.flush();
		 
	}

	

}
