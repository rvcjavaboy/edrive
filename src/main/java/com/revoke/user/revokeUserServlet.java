package com.revoke.user;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.sessionBean.AdminSessionBean;
import com.admin.sessionDAO.AdminSessionDAO;

/**
 * Servlet implementation class revokeUserServlet
 */
@WebServlet("/revokeUserServlet")
public class revokeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public revokeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		AdminSessionBean b1=new AdminSessionBean();
		b1.setUsername((String)session.getAttribute("emailadmin"));
		b1.setPass((String)session.getAttribute("passadmin"));
		boolean check=AdminSessionDAO.checkSession(b1);
		if(!check){
			response.sendRedirect("../../Admin.jsp?status=Please Login Again");
			
		}else{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		AdminSessionBean b1=new AdminSessionBean();
		b1.setUsername((String)session.getAttribute("emailadmin"));
		b1.setPass((String)session.getAttribute("passadmin"));
		boolean check=AdminSessionDAO.checkSession(b1);
		if(!check){
			response.sendRedirect("../../Admin.jsp?status=Please Login Again");
			
		}else{
			System.out.println("Revoke User Start");
			Enumeration<String> e=request.getParameterNames();
			while(e.hasMoreElements()){
				String key=e.nextElement();
				com.user.revokeBean.RevokeUserBean r=new com.user.revokeBean.RevokeUserBean();
				
				r.setId(Integer.parseInt(key));
				com.revoke.userDAO.RevokeUserDAO.deleteUser(r);
				
				
			}
			
			response.sendRedirect("/Account/admin/revoke_user.jsp?status_revoke=User Account removed Sccessfully");
		
	}
	}
}
