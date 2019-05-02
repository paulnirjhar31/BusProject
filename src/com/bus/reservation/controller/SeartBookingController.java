package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.reservation.serviceimpl.BusServiceImpl;
import com.bus.reservation.serviceimpl.CityServiceImpl;




@WebServlet("/SeatBooking")
public class SeartBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SeartBookingController() {      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/book1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedSeat=request.getParameter("selectedSeat");
		String busId=request.getParameter("busId");
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");	
		String fare=request.getParameter("fare");
		BusServiceImpl bipl=new BusServiceImpl();
		CityServiceImpl csi=new CityServiceImpl();
		HttpSession session=request.getSession(true);
		session.setAttribute("selectedSeat", selectedSeat);
		session.setAttribute("busId", busId);
		session.setAttribute("busdetails", bipl.getBusDetails(busId, fromCity, toCity));
		session.setAttribute("fromCity", fromCity);
		session.setAttribute("fromCityText", csi.getCityName(fromCity));
		session.setAttribute("toCity", toCity);
		session.setAttribute("toCityText", csi.getCityName(toCity));
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);
		session.setAttribute("fare", fare);
		
		RequestDispatcher rd=request.getRequestDispatcher("/book1.jsp");
		rd.forward(request, response);
	}

}
