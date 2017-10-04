package com.forgot.pass;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forgotValidate
 */
@WebServlet("/forgotValidate")
public class forgotValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("session_pass");
		String Email_id=request.getParameter("email_id");
		
		HttpSession session=request.getSession();
		if(!session.isNew()){
		if(session.getId().equals(id)){
				PrintWriter out=response.getWriter();
				System.out.println("Yes");
				response.setContentType("text/html");
				session.setAttribute("email",Email_id);
				RequestDispatcher req=request.getRequestDispatcher("changePassword.jsp");
				req.forward(request, response);
			
			}else{
				response.sendRedirect("forgotpass.jsp?forgot_status=Session Expired Please Try Again");
					
				
			}
		}else{
			
			response.sendRedirect("forgotpass.jsp?forgot_status=Please Try Again");
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
