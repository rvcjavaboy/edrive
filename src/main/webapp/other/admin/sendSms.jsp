<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Online Notice Board Admin Profile</title>
		<%
			String s=request.getParameter("success");
			if(s!=null&&s!=""){
			out.println("<script type='text/javascript'>alert("+s+");</script>");	
				
			}
			
			%>
   
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

  
    <link href="../css/dashboard.css" rel="stylesheet">

   
    <script src="../js/ie-emulation-modes-warning.js"></script>

  
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Welcome Admin !</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="logout.php">Logout</a></li>
          </ul>
         
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="sendSms.jsp">Send SMS <span class="sr-only">(current)</span></a></li>
			
			
            <li><a href="#"><img src="../images/person.jpg" width="100" height="100" alt="not found"/></a></li>
			
			
			
			
			<li><a href="index.php?page=update_password"><span class="glyphicon glyphicon-user"></span> Update Password</a></li>
            <li><a href="index.php?page=manage_users"><span class="glyphicon glyphicon-user"></span> Manage Users</a></li>
			 <li><a href="index.php?page=notification"><span class="glyphicon glyphicon-envelope"></span> Mange Notification</a></li>
			 
             <li><a href="index.php?page=add_notice"><span class="glyphicon glyphicon-envelope "></span> Add Notice For Faculty</a></li>
			  <li><a href="index.php?page=add_notice_std"><span class="glyphicon glyphicon-envelope "></span> Add Notice For Students</a></li>
			 
             
			 
          </ul>
         
         
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         
		  
		
		  
		  <h1 class="page-header">Select The Users</h1>
		  
		<form action='../../SendSmsServlet' method="post">
    <table class="table table-bordered">
		<tr class="success"><th>Enter The Message<th><td>
	<textarea  name="msg" rows="4" cols="50"></textarea>
		
		
		<td></tr>
		<tr class="success"><th>Enter The Number<th><td>
		<textarea  name="number" rows="4" cols="50"value placeholder="(Example 9600235632,9620562235)Example Number Seprate By ,"></textarea>
		
		
		<td></tr>

    </table>
		
		
<%@page import="com.account.session.mgm.UserSession,java.sql.*,com.db.Connection.*"%>
	


		
		

		  
		<centre><input type="submit" class="btn btn-success" value="Send SMS"/></centre>
         </form>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../js/bootstrap.min.js"></script>
   
    <script src="../js/vendor/holder.min.js"></script>
   
    <script src="../js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
