<%@page import="com.bus.reservation.models.*"%>
<%@page import="java.util.*"%>
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
	 <div id="printDiv">
			<%BusDetails bd=(BusDetails)session.getAttribute("busdetails"); 
	 		String fromCity=(String)session.getAttribute("fromCityText");
	 		String toCity=(String)session.getAttribute("toCityText");
	 		String fare=(String)session.getAttribute("fare");
	 		ArrayList<PassengerDetail> allPassenger=(ArrayList<PassengerDetail>)session.getAttribute("passengerlist"); 
	 		int totalFare=allPassenger.size()*Integer.parseInt(fare);
	 		String contactEmail=(String)session.getAttribute("bookingemailid");
	 		String phone=(String)session.getAttribute("bookingmobilenumber");
	 		String startDate=(String)session.getAttribute("startDate");
	 		%>
	 
			<p style="margin-top: 15px;font-size: 15px; color: black; font-weight: bold;">Summary</p>
			<hr/>
			<h4 style="display:inline;"><%=bd.getCompanyName()%></h4>
			 <p style="display:inline;font-size: 15px;color: black;font-weight: 200;">A/C Sleeper (1+1)</p> 
			 <p style="display:inline;font-size: 15px;color: black;font-weight: 200;"><%=fromCity%> To <%=toCity %></p> 
			<p style="display:inline;font-size: 15px;color: black;font-weight: 200;">Journey Start at <%=startDate %> <%=bd.getDepartingTime() %></p> 
			<p style="margin-top: 15px;font-size: 15px; color: black; font-weight: bold;">Passenger Infomation</p>
			
			<table class="table">
					<thead>
					  <tr>
						<th>Name</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Seat Number</th>
					  </tr>
					</thead>
					<tbody>
					
					<%
					for(PassengerDetail pd : allPassenger) {
					%>
					 <tr>
						<td><%=pd.getName() %></td>
						<td><%=pd.getAge() %></td>
						<td><%=pd.getGender() %></td>
						<td><%=pd.getSeatNumber() %></td>
					  </tr>
					<%} %>
					</tbody>
			</table>

			<h2>Total Fare : <%=totalFare %></h2>
			<hr/>
			<h4 style="display:inline;">Tickets will be sent to <%=contactEmail %>/<%=phone %></h4> &nbsp; &nbsp; <button type="button" class="btn btn-link" onClick="javascript:window.print()">Print</button>
		</div>
     
   
		
	</div>
</div>

<script>
function printDiv(){
	function printDiv() 
	{

	  var divToPrint=document.getElementById('printDiv');
	  var newWin=window.open('','Print-Window');
	  newWin.document.open();
	  newWin.document.write('<html><body onload="window.print()">'+divToPrint.innerHTML+'</body></html>');
	  newWin.document.close();
	  //setTimeout(function(){newWin.close();},10);
	  }
}

$('#printticket').click(function(){
	printDiv();
});

</script>
<%@ include file="/routes.jsp" %>
<%@ include file="/copywrite.jsp" %>
<%@ include file="/signin.jsp" %>
<%@ include file="/seatselection.jsp" %>
<%@ include file="/writetous.jsp" %>



</body>
</html>