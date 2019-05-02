package com.bus.reservation.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bus.reservation.models.UserDetails;
import com.bus.reservation.serviceimpl.LoginServiceImpl;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logintype = request.getParameter("logintype");
		String lemailmobile = request.getParameter("lemailmobile");
		String password = request.getParameter("lpassword");
		LoginServiceImpl lsi = new LoginServiceImpl();
		boolean finalReuslt=false;
		if (logintype.equalsIgnoreCase("otp")) {
			
			boolean result = lsi.checkLoginOtp(lemailmobile, password);
			System.out.println("result here is : "+result);
			if (result) {
				UserDetails userDetails = lsi.getUserDetailsByMobile(lemailmobile);
				lsi.updateOtpTable(lemailmobile);
				if (null == userDetails.getType()) {
					userDetails.setType("OTPValidatedUser");
				}
				HttpSession session = request.getSession(true);
				session.setAttribute("UserDetails", userDetails);
				finalReuslt=true;
			}
		} else {
			UserDetails userDetails=lsi.checkLoginPassword(lemailmobile, password);
			
			if(userDetails !=null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("UserDetails", userDetails);
				finalReuslt=true;
			}
		}
		if(!finalReuslt) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginfailuermessage", "login failed");
		} 
		response.sendRedirect("/BusProject");
	}

}
