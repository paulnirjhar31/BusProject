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

import com.bus.reservation.serviceimpl.RegistrationLoginServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/Register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("sname");
		String smobile=request.getParameter("smobile");
		String semail=request.getParameter("semail");
		String spassword=request.getParameter("spassword");
		
		RegistrationLoginServiceImpl rlsi=new RegistrationLoginServiceImpl();
		rlsi.doRegister(name, semail, smobile, spassword, "USER", "Y");
		
		System.out.println(name+" "+smobile+" "+semail+" "+spassword);
		Map<String, String> allResult=new HashMap<String, String>();
		allResult.put("result", "success");
		String resultString=new Gson().toJson(allResult);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(resultString);
		out.flush();
		
	}

}
