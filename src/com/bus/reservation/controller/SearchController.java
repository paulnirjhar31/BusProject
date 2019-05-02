package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.models.BusDetails;
import com.bus.reservation.serviceimpl.BusServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/BusList")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	
    
    
		@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String fromCityId = request.getParameter("fromCity");
			String toCityId = request.getParameter("toCity");
			String startDate=request.getParameter("startDate");
			String returnDate=request.getParameter("returnDate");
			
			//set these attributes to request
			request.setAttribute("fromCityId", fromCityId);
			request.setAttribute("toCityId", toCityId);
			request.setAttribute("startDate",startDate);
			request.setAttribute("returnDate", returnDate);
			
			RequestDispatcher rd=request.getRequestDispatcher("/buslist.jsp");
			rd.forward(request, response);
			
	}





		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String fromCityId = request.getParameter("fromCity");
		String toCityId = request.getParameter("toCity");
		System.out.println(fromCityId +"--------------"+toCityId);
		
		
		BusServiceImpl busServiceImpl=new BusServiceImpl();
		List<BusDetails> allBusses=busServiceImpl.getAllAvailableBusses(fromCityId, toCityId);
		/*request.setAttribute("busList", allBusses);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/buslisting.jsp");
		dispatcher.forward(request, response);*/
		
		String resultString=new Gson().toJson(allBusses);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(resultString);
		out.flush();
		
	}

}
