package com.bus.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.reservation.models.PassengerDetail;
import com.bus.reservation.serviceimpl.BusServiceImpl;

@WebServlet("/SUCCESS")
public class BookingSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(true);
		String selectedSeat=(String) session.getAttribute("selectedSeat");
		String busId=(String) session.getAttribute("busId");
		String fromCity=(String) session.getAttribute("fromCity");
		String toCity=(String) session.getAttribute("toCity");
		String startDate=(String) session.getAttribute("startDate");
		String endDate=(String) session.getAttribute("endDate");
		
		String bookingMailid=(String) session.getAttribute("bookingemailid");
		String bookingMobileNumber=(String)session.getAttribute("bookingmobilenumber");
		ArrayList<PassengerDetail> allPassenger =(ArrayList<PassengerDetail>) session.getAttribute("passengerlist");
		
		//BusServiceImpl bipl=new BusServiceImpl();
		//bipl.saveBookingInformation(allPassenger,busId,fromCity,toCity,startDate,endDate, bookingMailid, bookingMobileNumber );
		RequestDispatcher rd=request.getRequestDispatcher("/book3.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(true);
		String selectedSeat=(String) session.getAttribute("selectedSeat");
		String busId=(String) session.getAttribute("busId");
		String fromCity=(String) session.getAttribute("fromCity");
		String toCity=(String) session.getAttribute("toCity");
		String startDate=(String) session.getAttribute("startDate");
		String endDate=(String) session.getAttribute("endDate");
		
		String bookingMailid=(String) session.getAttribute("bookingemailid");
		String bookingMobileNumber=(String)session.getAttribute("bookingmobilenumber");
		ArrayList<PassengerDetail> allPassenger =(ArrayList<PassengerDetail>) session.getAttribute("passengerlist");
		
		BusServiceImpl bipl=new BusServiceImpl();
		bipl.saveBookingInformation(allPassenger,busId,fromCity,toCity,startDate,endDate, bookingMailid, bookingMobileNumber );
		RequestDispatcher rd=request.getRequestDispatcher("/book3.jsp");
		rd.forward(request, response);
	}

}
