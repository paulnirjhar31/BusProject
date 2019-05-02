<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GreenLine Home</title>
</head>
<body>


<form action="/BusProject/result" method="post">

<select name="fromCity">	
	<%
	Map<String, String> allSource=(Map)request.getAttribute("SourceList");	
	for (Map.Entry<String, String> entry : allSource.entrySet()) {
	%>
	<option value="<%=entry.getKey()%>"> <%=entry.getValue()%></option>		
	<%}%>
</select>


<br/>

<select name="destCity">
	<%
	Map<String, String> allDestination=(Map)request.getAttribute("DestinationList");
	for (Map.Entry<String, String> entry : allDestination.entrySet()) {
	%>
		<option value="<%=entry.getKey()%>"> <%=entry.getValue()%></option>		
	<%}%>
</select>

<input type="text"/> <br/>
<input type="text">
<input type="submit" value="search">
</form>

</body>
</html>