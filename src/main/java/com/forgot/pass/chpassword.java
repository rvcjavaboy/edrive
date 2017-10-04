package com.forgot.pass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class chpassword
 */
@WebServlet("/chpassword")
public class chpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chpassword() {
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
		String cpass,pass;
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		pass=request.getParameter("pass");
		cpass=request.getParameter("cpass");
		if(!cpass.equals(pass)){
			response.sendRedirect("forgotValidate?session_pass="+session.getId()+"&email_id="+session.getAttribute("email")+"&passmatch_status=password not Macth");
			
		}else{
			boolean b=com.forgot.pass.PasswordChangeDAO.passChange(email, pass);
			if(b){
				response.sendRedirect("login.jsp?status=password change sucessfully");
				
			}else{
				response.sendRedirect("forgotpass.jsp?forgot_status=Please Try Again");
				
				
			}
			
		}
		
		
	}

}
