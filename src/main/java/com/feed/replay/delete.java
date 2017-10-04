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
 * Servlet implementation class delete
 */
@WebServlet("/Account/admin/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		AdminSessionBean b1=new AdminSessionBean();
		b1.setUsername((String)session.getAttribute("emailadmin"));
		b1.setPass((String)session.getAttribute("passadmin"));
		boolean check=AdminSessionDAO.checkSession(b1);
		if(!check){
			response.sendRedirect("../../Admin.jsp?status=Please Login Again");
			
		}else{
		String feed_id=request.getParameter("feed_id");
		boolean b=com.feed.replay.DeleteDAO.DeleteFeed(Integer.parseInt(feed_id));
		if(b){
		response.sendRedirect("feedback.jsp?delete_status=Feedback Deleted Successfully");
		}else{
		response.sendRedirect("feedback.jsp?delete_status=Feedback Deleted Failed");
		}
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
