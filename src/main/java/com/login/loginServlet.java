package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		com.login.Bean.Login l=new com.login.Bean.Login();
		l.setName(request.getParameter("email"));
		l.setPass(request.getParameter("pass"));
		l.setType(request.getParameter("type"));
		boolean status =com.login.DAO.LoginDAO.getAccess(l);
		if(status){
			
			HttpSession session=request.getSession();
			
			if(l.getType().equals("Creator")){
				session.setAttribute("c_email",l.getName());
				session.setAttribute("c_pass", l.getPass());
				session.setAttribute("c_type", l.getType());
				response.sendRedirect("Account/creator/home.jsp");	
				}else if(l.getType().equals("Reader")){
					session.setAttribute("r_email",l.getName());
					session.setAttribute("r_pass", l.getPass());
					session.setAttribute("r_type", l.getType());
					response.sendRedirect("Account/reader/home.jsp");	
					}else if(l.getType().equals("Writer")){
						session.setAttribute("w_email",l.getName());
						session.setAttribute("w_pass", l.getPass());
						session.setAttribute("w_type", l.getType());
						response.sendRedirect("Account/writer/home.jsp");	
						}
			
			
			
		}else{
			response.sendRedirect("login.jsp?status=Login Falied");
			
			
		}
		
	}

}
