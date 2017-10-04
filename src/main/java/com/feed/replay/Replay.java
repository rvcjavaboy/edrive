package com.feed.replay;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.sessionBean.AdminSessionBean;
import com.admin.sessionDAO.AdminSessionDAO;

/**
 * Servlet implementation class Replay
 */
@WebServlet("/Account/admin/Replay")
public class Replay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Replay() {
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
			
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		AdminSessionBean b1=new AdminSessionBean();
		b1.setUsername((String)session.getAttribute("emailadmin"));
		b1.setPass((String)session.getAttribute("passadmin"));
		boolean check=AdminSessionDAO.checkSession(b1);
		if(!check){
			response.sendRedirect("../../Admin.jsp?status=Please Login Again");
			
		}else{
		String feed_id=request.getParameter("feed_id");
		String msg=request.getParameter("replymsg");
		String email=request.getParameter("email");
		System.out.println(msg);
		boolean b=com.feed.replay.ReplayDAO.replay(msg, email);
		if(b){
			response.sendRedirect("viewfeed.jsp?status_feedback=Message Send Sucessfully&feed_id="+feed_id);
			
		}else{
			response.sendRedirect("viewfeed.jsp?status_feedback=Message Send Falied&feed_id="+feed_id);
			
			
		}
		}
		
	}

}
