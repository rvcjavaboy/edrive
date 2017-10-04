<!DOCTYPE html>
<!--
@Author:rvcinfo9600
@Date:27/3/2016
-->
<%@page import="com.admin.sessionBean.AdminSessionBean"%>
<html lang="en">
	<head>
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
		
		<%@page language="java" import="com.admin.sessionDAO.*,java.sql.*,com.db.Connection.*" %>
		<% 
				AdminSessionBean b=new AdminSessionBean();
				b.setUsername((String)session.getAttribute("emailadmin"));
				b.setPass((String)session.getAttribute("passadmin"));
				boolean check=AdminSessionDAO.checkSession(b);
				if(!check){
					response.sendRedirect("../../Admin.jsp?status=Please Login Again");
					
				}
		%>
	</head>
	<body>

		<!-- Header -->
			<header id="header">
						<h1><a href="../../index.jsp">E Drive</a></h1>

				<nav id="nav">
					<ul>

						<li><a href="home.jsp">Home</a></li>
						<li><a href="request.jsp">Request</a></li>
						<li><a href="revoke_user.jsp">Revoke Request</a></li>	
						<li><a href="feedback.jsp">View Feedback</a></li>
						<li><a href="../../logoutSession" class="button special">Log out</a></li>
						
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">
					<header class="major">
						<h2>Feedback</h2>
						<table style="padding-left=10cm;">
						<% 
					

						Connection con=MyConnection.getConnection();
						Statement st=con.createStatement();
						ResultSet rst=st.executeQuery("select * from feed where status=0 AND id="+request.getParameter("feed_id"));
						%>
						<%if(rst.next()){ %>
						<form action="Replay?feed_id=<%=request.getParameter("feed_id")%>&email=<%=rst.getString(3) %>" method="post">
<% String s1=request.getParameter("status_feedback");
if(s1!=null&&s1!=""){
out.println("<tr style='color:red;font-weight:bold;'><td>"+s1+"<td></tr>");	

}
	%>					<tr><td><b>Name</b></td><td><%=rst.getString(2) %></td></tr>
						<tr><td><b>Email</b></td><td><%=rst.getString(3) %></td></tr>
						<tr><td><b>Message</b></td><td><textarea name="msg" rows="6" readonly="readonly"><%=rst.getString(4)%></textarea></td></tr>
						<tr><td><b>Reply Message</b></td><td><textarea name="replymsg" id="msg" value placeholder="message" rows="6"></textarea></td></tr>
												
						</table>
						
						<center><input type="submit" value="Replay" class="button small">&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp<a href="delete?feed_id=<%=request.getParameter("feed_id")%>" class="button small">Delete</a></center>
						</form>
						<% }%>

						
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