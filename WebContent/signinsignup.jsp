<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bus.reservation.models.*"%>
    <!-- top-header -->
<div class="top-header">
	<div class="container">
		<ul class="tp-hd-lft wow fadeInLeft animated" data-wow-delay=".5s">
			<li class="hm"><a href="/BusProject"><i class="fa fa-home"></i></a></li>				
		</ul>
		<ul class="tp-hd-rgt wow fadeInRight animated" data-wow-delay=".5s"> 
			<li class="tol">Toll Number : 123-4568790</li>
			
			<%UserDetails ud=(UserDetails)session.getAttribute("UserDetails"); 
			if(ud==null){
			%>							
			<li class="sig"><a href="#" data-toggle="modal" data-target="#myModal" >Sign Up</a></li> 
			<li class="sigi"><a href="#" data-toggle="modal" data-target="#myModal4" >/ Sign In</a></li>
			<%} else {%>
			<li class="sig">Welcome <%=ud.getName() %> <a href="/BusProject/Logout">Log out</a></li> 
			<%} %> 
        </ul>
        
       
		<div class="clearfix"></div>
	</div>
</div>
<!--- /top-header ---->