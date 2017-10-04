<!DOCTYPE html>
	<!--
@Author:rvcinfo9600
@Date:27/3/2016
-->
<%@page import="com.account.session.mgm.UserSession"%>
<html lang="en">
	<head>
		<% 
		String email,pass,type;
			email=(String)session.getAttribute("w_email");
			pass=(String)session.getAttribute("w_pass");
			type=(String)session.getAttribute("w_type");
			System.out.println("E"+email+"pass"+pass+"type"+type);
			boolean b=UserSession.getSessionAvaliable(email, pass, type);
			if(!b){
				response.sendRedirect("../../login.jsp?status=Please Login Again");
				}
			
		
		%>
	
		<meta charset="UTF-8">
		<title>E Drive</title>
			<link rel="icon" href="../../images/Eicon.png" type="image/x-icon" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="../../js/jquery.min.js"></script>
		<script src="../../js/skel.min.js"></script>
		<script src="../../js/skel-layers.min.js"></script>
		<script src="../../js/init.js"></script>
		<script src="../../validation/login.js"></script>
		
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<h1><a href="../../index.jsp">E Drive</a></h1>
	
				<nav id="nav">
					<ul>

						<li><a href="home.jsp">Home</a></li>
						<li><a href="file_list.jsp">File List</a></li>
							<li><a href="modify_file.jsp">Modify File</a></li>
						<li><a href="../../logoutSession" class="button special">Log out</a></li>
						
						
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">
					<header class="major">
						<h2>Modify File</h2>
						<h3>Please Check mail for Secret Key</h3>
				<table>
	<%
		if(b){
			String s=request.getParameter("key_status");
			if(s!=null&&s!=""){
			out.println("<center><tr style='color:red;font-weight:bold;'><td>"+s+"<td></tr><center>");	
				
			}
		}
			%>
			<% 
			String file_id=request.getParameter("reqest_id");
			System.out.println("File Id"+file_id);
			%>
		<form action= "modifyfile?reqest_id=<%=file_id%>&author=<%=request.getParameter("author")%>" method="post">	
	
		<tr><td><b>Enter Secret Key</b></td><td><input type="text" id='key' value placeholder="secret key" name="key" style="width:70%;font-family: cursive;"></td></tr>
		<input type="hidden" value=<%=file_id%> name="reqest_id"/>
			
	</table>
	<center><input type="submit" class="button special" Value="Check"></center>
							
					</form>
					</table>
</header>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<section class="links">
						<div class="row">
							<section class="3u 6u(medium) 12u$(small)">
								<h3>Creator</h3>
								<ul class="unstyled">
									<li>Creator Type User can upload file</li>
									<li>E Drive Cloud Provide Attribute Based,</li>
									<li>Encryption on File Creator can also,</li>
									<li>Share the file to friends who account,</li>
									<li>like Reade,Writer and also Creator Can Download File</li>
								</ul>
							</section>
							<section class="3u 6u$(medium) 12u$(small)">
								<h3>Writer</h3>
								<ul class="unstyled">
									<li>Writer Type User can  Download File</li>
									<li>Using Encryption Key</li>
									<li> And also Modifed file request Send,</li>
									<li>To the file owner(Creator) if file</li>
									<li> owner accept the request then File Store.On E-Drive Cloud</li>
								</ul>
							</section>
							<section class="3u 6u(medium) 12u$(small)">
								<h3>Reader</h3>
								<ul class="unstyled">
									<li>Reader Type User can Download file</li>
									<li>Using Encryption Key</li>
									<li>The File Cannot Download Until Key</li>
									<li>Not Match And That key will Decrypted</li>
									<li>File</li>
								</ul>
							</section>
							<section class="3u$ 6u$(medium) 12u$(small)">
								<h3>Admin</h3>
								<ul class="unstyled">
									<li>Admin can Accept the user register request</li>
									<li>on E-Drive Cloud,then login to the</li>
									<li>E-Drive Cloud The Admin Have Authentication to </li>
									<li>Remove Any User to The E-Drive Cloud</li>
									<li>If the Revoke request Send by Creator User Account</li>
								</ul>
							</section>
						</div>
					</section>
					<div class="row">
						<div class="8u 12u$(medium)">
							<ul class="copyright">
								<li>&copy; 2016-2017. E-Drive All rights reserved.</li>
								<li>Design: <a href=#>rvcinfo9600@gmail.com</a></li>
							</ul>
						</div>
						<div class="4u$ 12u$(medium)">
							<ul class="icons">
								<li>
									<a href="https://web.facebook.com/E-Drive-985983191493225" class="icon rounded fa-facebook"><span class="label">Facebook</span></a>
								</li>
								<li>
									<a class="icon rounded fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li>
									<a class="icon rounded fa-google-plus"><span class="label">Google+</span></a>
								</li>
								<li>
									<a class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>

	</body>
</html>