<!DOCTYPE html>
<!--
@Author:rvcinfo9600
@Date:27/3/2016
-->
<html lang="en">
	<head>
		<%@page import="com.admin.sessionBean.AdminSessionBean,com.db.Connection.MyConnection"%>
		<%@page language="java" import="com.admin.sessionDAO.*,java.sql.*" %>
		<% 
				AdminSessionBean b=new AdminSessionBean();
				b.setUsername((String)session.getAttribute("emailadmin"));
				b.setPass((String)session.getAttribute("passadmin"));
				boolean check=AdminSessionDAO.checkSession(b);
				if(!check){
					response.sendRedirect("../../Admin.jsp?status=Please Login Again");
					
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
					<h2>Revoke Request</h2>
							<form action="../../revokeUserServlet" method="post">
									<table>
												<%
			String s1=request.getParameter("status_revoke");
			if(s1!=null&&s1!=""){
			out.println("<center><tr style='color:red;font-weight:bold;'><td>"+s1+"<td></tr><center>");	
				
			}
			%>	
<tr><td><b>User Name</b></td><td><b>Email Id</b></td><td><b>Type</b></td><td><b>Sender</b></td><td><b>Revoke</b></td></tr>						
<% 
try{
	if(check){
	Connection con=MyConnection.getConnection();
	Statement st=con.createStatement();
	Statement st1=con.createStatement();
	String query="select * from revoke_user";
	System.out.println(query);
	ResultSet rst=st.executeQuery(query);
	
	while(rst.next()){
		ResultSet rs=st1.executeQuery("select name,email,type from regi where id="+rst.getInt(1));
		if(rs.next()){
		out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rst.getString(2)+"</td><td><input type='checkbox' id='"+rst.getString(1)+"' name="+rst.getInt(1)+"><label for='"+rst.getInt(1)+"'>Accept</label></td></tr>");
		}
	}out.println("</table>");
	out.println("<center><input type=submit class='fit-small' value='Submit'></center>");}
}catch(Exception e){e.printStackTrace();}

%>										
						</table>
						</form>
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