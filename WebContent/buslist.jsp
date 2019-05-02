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
<div class="banner-1 ">
	<div class="container">
		<h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Green Wheels - Best in Class for Travel & Hotels</h1>
	</div>
</div>
<!--- /banner-1 ---->
<!--- bus-tp ---->
<div class="bus-tp">
	<div class="container">
		<!-- <p>Fare starts from : USD. 600</p> -->
		<h2 id="routeSummery">test</h2>
		<div class="clearfix"></div>
	</div>
</div>
<div class="bus-btm">
	<div class="container">
		<ul>
			<li class="trav"><a href="#">Travels</a></li>
			<li class="dept"><a href="#">Depart</a></li>
			<li class="arriv"><a href="#">Arrive</a></li>
			<li class="seat"><a href="#">Seats</a></li>
			<li class="fare"><a href="#">Fare</a></li>
				<div class="clearfix"></div>
		</ul>
	</div>
</div>

<div class="bus-midd wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;">
	<div class="container" id="busListDiv">
	
		
	</div>
</div>

<%@ include file="/routes.jsp" %>
<%@ include file="/copywrite.jsp" %>
<%@ include file="/signin.jsp" %>
<%@ include file="/seatselection.jsp" %>
<%@ include file="/writetous.jsp" %>

<script src="js/buslist.js"></script>

</body>
</html>