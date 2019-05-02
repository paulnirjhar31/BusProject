<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.bus.reservation.models.BusDetails" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Listing</title>
</head>
<body>
	<% List<BusDetails> allBusses= (List<BusDetails>)request.getAttribute("busList");
		for(BusDetails bd : allBusses) {
			%>
		<%=bd %> <br/>
		<%}
	%>
</body>
</html>