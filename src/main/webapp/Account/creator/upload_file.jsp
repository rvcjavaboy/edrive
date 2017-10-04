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
			email=(String)session.getAttribute("c_email");
			pass=(String)session.getAttribute("c_pass");
			type=(String)session.getAttribute("c_type");
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
		<script src="../../validation/uploadvalid.js"></script>
		
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
						<li><a href="upload_file.jsp">Upload File</a></li>
						<li><a href="upload_file_list.jsp">Files</a></li>	
						<li><a href="modifed_file_list.jsp">Modify File Request</a></li>
						
						<li><a href="revoke_request.jsp">Send Revoke Request</a></li>	
						<li><a href="../../logoutSession" class="button special">Log out</a></li>
						
					</ul>
				</nav>
			</header>

		<!-- Main -->
	
			<section id="main" class="wrapper">
				<div class="container">
					<header class="major">
						<h2>Upload File</h2>
					</header>
					<form action="../../uploadFile" enctype="multipart/form-data" method="post" onsubmit=" return chkSize()">
				<center>
				<table>
				<%
				//if(b){
			String s=request.getParameter("file_status");
			if(s!=null&&s!=""){
			out.println("<center><tr style='color:red;font-weight:bold;'><td>"+s+"<td></tr><center>");	
				
			}
			//	}
			%>
					<tr><td><b>Select File</b></td><td><input type="file" id='file' name="file">			
			</td><td>(File  Size < 16MB)</td></tr>

				</table>
					<input type="submit" value="Upload File" >

				</center>
				</form>
				

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