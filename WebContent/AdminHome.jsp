<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
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
<link href="css/graph.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
</head>
</head>
<body>
<%@ include file="/signinsignup.jsp" %>
<%@ include file="/header.jsp"%>

<div class="bus-midd wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;">
	<div class="container">
		<div class="row" style="margin-top: 20px;margin-bottom: 20px;min-height: 700px;">
		<div class="col-sm-3">

			<!-- List-Group Panel -->
			<div class="card">
				<div class="card-header p-b-0">
					<h5 class="card-title"><i class="fa fa-random" aria-hidden="true"></i>&nbsp; Manage City</h5>
				</div>
				<div class="list-group list-group-flush">
					<a page="cityadd" class="menulink list-group-item list-group-item-action">Manage City/Stops</a>
					<a page="routesmanagement" class="menulink list-group-item list-group-item-action">Manage Routes</a>
					<a page="busmanagement" class="menulink list-group-item list-group-item-action">Bus Management</a>
				</div>
			</div>

			<!-- Text Panel -->
			<div class="card">
				<div class="card-header p-b-0">
					<h5 class="card-title"><i class="fa fa-cog" aria-hidden="true"></i> Admin Home</h5>
				</div>

				<div class="card-block">
					<p class="card-text">this is admin home, to start, please click on links present above this text</p>
					<p><button class="btn btn-secondary">Help</button></p>
				</div>
			</div>

			
				
		</div><!--/Left Column-->
  
  
		
		<div class="col-sm-9" id="adminContentContainer">
		
	 
		</div>
		
		<script>
			$(".menulink").click(function() {
				console.log($(this).attr('page'));
				
				var page=$(this).attr('page');
				$('#adminContentContainer').load('adminFunction/'+page+'.html');
				
				return false;
			});				
		</script>
		
	</div>
	</div>
</div>

<%@ include file="/copywrite.jsp" %>
<%@ include file="/signin.jsp" %>
<%@ include file="/seatselection.jsp" %>
<%@ include file="/writetous.jsp" %>
	

</body>
</html>