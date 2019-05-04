<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!-- sign -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
							<section>
								<div class="modal-body modal-spa">
									<div class="login-grids">
										<div class="login">
											
											<div class="login-right">
												<form id="signupform">
													<h3>Create your account </h3>
													<input id="sname" name="sname" type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
													<input id="smobile" name="smobile" type="text" value="Mobile number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobile number';}" required="">
													<input id="semail" name="semail" type="text" value="Email id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email id';}" required="">	
													<input id="spassword" name="spassword" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
													<input type="submit" value="CREATE ACCOUNT" id="createAccount">
												</form>
											</div>
											<div class="login-left">
												<ul>
													<li><a class="fb" href="#"><i></i>Sign in with Facebook</a></li>
													<li><a class="goog" href="#"><i></i>Sign in with Google</a></li>
													<li><a class="linkin" href="#"><i></i>Sign in with Linkedin</a></li>
												</ul>
											</div> 
												<div class="clearfix"></div>								
										</div>
											<p>By logging in you agree to our <a href="terms.html">Terms and Conditions</a> and <a href="privacy.html">Privacy Policy</a></p>
									</div>
								</div>
							</section>
					</div>
				</div>
			</div>

		<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>											
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
								<div class="login">
									
									<div class="login-right">
										<form method="post" action="/BusProject/Login">
											<h3>Signin with your account </h3>
											<input id="lemailmobile" name="lemailmobile" type="text" value="Enter your mobile number or Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your mobile number or Email';}" required="">	
											 <label class="inputLabel" style="margin-right: 5px;margin-top: 5px;">Login Using : </label>
										        <input type="radio" name="logintype" value="password" checked> Password
										        <input type="radio" name="logintype" value="otp"> Otp
											<input name="lpassword" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
											<h4><a href="#">Forgot password</a></h4>
											<div class="single-bottom">
												<input type="checkbox" id="brand" value="">
												<label for="brand"><span></span>Remember Me.</label>
											</div>
											<input type="SUBMIT" value="SIGNIN">
										</form>
									</div>
									<div class="login-left">
										<ul>
											<li><a class="fb" href="#"><i></i>Sign in with Facebook</a></li>
											<li><a class="goog" href="#"><i></i>Sign in with Google</a></li>
											<li><a class="linkin" href="#"><i></i>Sign in with Linkedin</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>								
								</div>
								<p>By logging in you agree to our <a href="terms.html">Terms and Conditions</a> and <a href="privacy.html">Privacy Policy</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script src="js/polyfill.js"></script>
			<script src="js/popupmodal-min.js"></script>
			<script>
			
			$("#createAccount").click(function(){
				
				var formData = {
			            'sname': $('#sname').val(),
			            'smobile': $('#smobile').val(),
			            'semail': $('#semail').val(),
			             'spassword': $('#spassword').val()
			        };
			
				$.post('/BusProject/Register',  
						formData, 
				        function(data) {				        
						$('#myModal').modal('hide'); 		
						popup.alert(
								{
									content : 'Registration Successfull, You can now login using email or mobile'
								}
							);
								
								
				       	}).done(function() {})
				        .fail(function(jqxhr, settings, ex) {
				        	$('#myModal').modal('hide'); 		
							popup.alert(
									{
										content : 'Registration failed, please try after sometime'
									}
								);
				        });
				
				return false;
			});	
			
			$('input[name=logintype]').click(function() {
				console.log($(this).val());
				if($(this).val()=='otp') {
					
					var mobile=$("#lemailmobile").val();
					
					$.post('/BusProject/OtpController',  
							{'mobile': mobile}, 
					        function(data) {				         		
							popup.alert(
									{
										content : data.message
									}
								);
					       	}).done(function() {})
					        .fail(function(jqxhr, settings, ex) {		
								popup.alert(
										{
											content : 'Failed to send otp please use password login'
										}
									);
					        });
					
				}
			});
			
			</script>
			
		<%String message=(String)session.getAttribute("loginfailuermessage");         
        if(message!=null && message.equals("login failed")) {
        session.removeAttribute("loginfailuermessage");
        %>
        <script>        
        $('#myModal4').modal('show');
        popup.alert(
				{
					content : 'Login Failed, please try again with correct credential'
				}
			);        
        </script>
        <%
        } %>
        
			
<!-- //signin -->