package com.bus.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.reservation.models.CityDetail;
import com.bus.reservation.serviceimpl.RegistrationLoginServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class OtpController
 */
@WebServlet("/OtpController")
public class OtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobile = request.getParameter("mobile");
		Random rand = new Random();		
		String otp = String.format("%04d%n", rand.nextInt(10000));
		otp=otp.trim();
		RegistrationLoginServiceImpl rsli=new RegistrationLoginServiceImpl();
		rsli.saveOtp(mobile, otp);
		Map<String,String> allResult=new HashMap<String, String>();
		allResult.put("message","Otp sent to mobile successfully, since there is not internet connection, please use this " + otp);
			
		String resultString=new Gson().toJson(allResult);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(resultString);
		out.flush();
	}
	
}
