package com.forgot.pass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sendpasskey
 */
@WebServlet("/sendpasskey")
public class sendpasskey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendpasskey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
				if(com.forgot.pass.checkEmail.email(request.getParameter("mail"))){
				
			boolean status=com.email.EmailSend.sendForgotPasswordLink(request.getParameter("mail"),session.getId());
			if(status){
				response.sendRedirect("forgotpass.jsp?forgot_status=Please Check your mail id link expried in 5 min");
				
				
			}else{
				response.sendRedirect("forgotpass.jsp?forgot_status=Mail Sending Falied");
				
				
			}
				}else{
					response.sendRedirect("forgotpass.jsp?forgot_status=Account Not Found");
						
					
				}
			
			
			
		
		
	}

}
