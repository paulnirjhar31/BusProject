<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Bus List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/seatselection.css" rel="stylesheet">
<link href="css/popupmodal.css" rel="stylesheet">
<script src="js/jquery-1.12.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
</head>
<body>

<div id="pageData" style="display: none;">fromCityId:<%=request.getAttribute("fromCityId")%>,toCityId:<%=request.getAttribute("toCityId")%>,startDate:<%=request.getAttribute("startDate")%>,returnDate:<%=request.getAttribute("returnDate")%></div>
<%@ include file="/signinsignup.jsp" %>
<%@ include file="/header.jsp"%>

<div class="bus-midd wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;">
	<div class="container">
	 <p style="margin-top: 15px;font-size: 15px; color: black; font-weight: bold;">Passenger Information</p>
     <hr/>
     <form action="/BusProject/ProceedCheckout" method="post">
	<%String selectedSeat=(String)session.getAttribute("selectedSeat");
	String[] allSeats=null;
	int i=1;
	if(selectedSeat!=null) {
		allSeats=selectedSeat.split(",");
	}
	for(String seat : allSeats){
		%>		
	  <p style=" font-weight: bold;color: black; margin-top: 5px; margin-bottom: 5px;">Pasenger <%=i%> | Seat <%=seat %></p>	
	
		<div style="margin-top: 25px;">
	 	<label class="inputLabel">Name</label>
        <input name="pasengername<%=seat %>" type="text" required="" style="width: 100%;"><br/>
        
        <div class="row">
        <div class="pull-left" style="margin: 15px;">
        <label class="inputLabel" style="margin-right: 5px;">Gender</label>
        <input type="radio" name="pasengergender<%=seat %>" value="male"> Male
        <input type="radio" name="pasengergender<%=seat %>" value="female"> Female
        </div>
        <div class="pull-left" style="margin: 15px;">
        <label class="inputLabel" style="margin-left: 10px;">Age</label>
        <input name="pasengerage<%=seat %>" type="text" required="" style=" margin-left: 5px;margin-right: 5px;width: 40px;">
        </div>
        </div>
        </div>
	<%
	i++;
	}
	%><hr/>
	
	<div style="margin-top: 25px;">
	
	<p style="margin-top: 15px;font-size: 15px; color: black; font-weight: bold;">Contact Information</p>
	<div style="margin-top: 20px;"></div>
	 	<label class="inputLabel">Email ID: </label>
        <input name="bookingemailid" type="text" required="" style="width: 45%;"><br/>
        
        <div style="margin-top: 15px;"></div>
        <label class="inputLabel">Mobile Number: </label>
        <input name="bookingmobilenumber" type="text" required="" style="width: 40%;"><br/>
      </div>
	 <div style="margin-top: 20px;"></div>
	<input type="button" class="btn btn-danger" value="Clear"/>&nbsp;<input type="submit" class="btn btn-success" value="Proceed"/>
	</form>	
		
	</div>
</div>

<%@ include file="/routes.jsp" %>
<%@ include file="/copywrite.jsp" %>
<%@ include file="/signin.jsp" %>
<%@ include file="/seatselection.jsp" %>
<%@ include file="/writetous.jsp" %>



</body>
</html>