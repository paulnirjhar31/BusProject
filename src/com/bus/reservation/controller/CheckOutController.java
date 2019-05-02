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

@WebServlet("/ProceedCheckout")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(true);
		String selectedSeat=(String) session.getAttribute("selectedSeat");		
		String[] allSeat=selectedSeat.split(",");
		
		ArrayList<PassengerDetail> allPassenger=new ArrayList<PassengerDetail>();
		
		for(int i=0;i<allSeat.length;i++) {
			PassengerDetail pd=new PassengerDetail();
			pd.setAge(request.getParameter("pasengerage"+allSeat[i]));
			pd.setSeatNumber(allSeat[i]);
			pd.setName(request.getParameter("pasengername"+allSeat[i]));
			pd.setGender(request.getParameter("pasengergender"+allSeat[i]));
			
			System.out.println(pd);
			allPassenger.add(pd);
		}
	
		session.setAttribute("bookingemailid", request.getParameter("bookingemailid"));
		session.setAttribute("bookingmobilenumber", request.getParameter("bookingmobilenumber"));
		session.setAttribute("passengerlist", allPassenger);
		RequestDispatcher rd=request.getRequestDispatcher("/book2.jsp");
		rd.forward(request, response);
		
	}

}
