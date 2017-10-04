package com.regi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regdb
 */
@WebServlet("/regdb")
public class regdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regdb() {
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
		String name,pass,email,phone,type,cpass;
		name=request.getParameter("name");
		pass=request.getParameter("pass");
		email=request.getParameter("email");
		phone=request.getParameter("phone");
		type=request.getParameter("type");
		cpass=request.getParameter("cpass");
		
		com.reg.Bean.Register r_Bean=new com.reg.Bean.Register();
		r_Bean.setName(name);
		r_Bean.setEmail(email);
		r_Bean.setPass(pass);
		r_Bean.setCpass(cpass);
		r_Bean.setPhone(phone);
		r_Bean.setType(type);
		boolean b=com.reg.DAO.RegisterDAO.regDB(r_Bean);
		if(b==true){
		com.email.EmailSend.emailSendAPI(r_Bean.getEmail(),com.reg.DAO.RegisterDAO.getID(r_Bean),com.keygenrator.Key.getKey());
			
			response.sendRedirect("login.jsp?status=Please Check Your Mail Id Account Verfication");
			
		}else{
			response.sendRedirect("register.jsp?reg_status=Email id Allready registered");
			
		}
		
		
		
		
	}

}
