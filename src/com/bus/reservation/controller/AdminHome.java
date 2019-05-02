package com.bus.reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.reservation.models.UserDetails;


@WebServlet("/Admin")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		UserDetails ud=(UserDetails) session.getAttribute("UserDetails");
		
		if(ud !=null && ud.getType().equalsIgnoreCase("ADMIN")) {
			RequestDispatcher rd=request.getRequestDispatcher("/AdminHome.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/BusProject");
		}
		
	}

}
