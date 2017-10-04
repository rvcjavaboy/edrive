package com.revoke;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;
import com.revoke.DAO.RevokeDAO;

/**
 * Servlet implementation class revokerequest
 */
@WebServlet("/revokerequest")
public class revokerequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public revokerequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("c_email");
		String pass=(String)session.getAttribute("c_pass");
		String type=(String)session.getAttribute("c_type");
		System.out.println("E"+email+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email, pass, type);
		if(!b){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}else{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("c_email");
		String pass=(String)session.getAttribute("c_pass");
		String type=(String)session.getAttribute("c_type");
		System.out.println("E"+email+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email, pass, type);
		if(!b){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}else{
		
		doGet(request, response);
		try{
		
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			String query="DELETE FROM revoke_user WHERE sender  ='"+(String)session.getAttribute("c_email")+"'";
			System.out.println(query);
			int i=st.executeUpdate(query);
			    
		}catch(Exception e){e.printStackTrace();}
		
		int i=0;
		 session=request.getSession();
		com.revoke.Bean.RevokeBean r;
		Enumeration<String>e=request.getParameterNames();
		while(e.hasMoreElements()){
			r=new com.revoke.Bean.RevokeBean();
			String author=(String) session.getAttribute("c_email");
			String key=e.nextElement();
			String value=request.getParameter(key);
			System.out.println("KEY"+key);
			r.setReg_id(Integer.parseInt(key));
			r.setSender(author);
			RevokeDAO.sendRevokeRequest(r);
		}
	
		response.sendRedirect("/Account/creator/revoke_request.jsp?status_revoke=revoke request send  Sucessfully");

		
	
	
	}
	}
	
}
