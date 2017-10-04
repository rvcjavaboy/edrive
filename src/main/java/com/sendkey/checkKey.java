package com.sendkey;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;

/**
 * Servlet implementation class checkKey
 */
@WebServlet("/Account/creator/checkkey")
public class checkKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email1,pass,type;
		email1=(String)session.getAttribute("c_email");
		pass=(String)session.getAttribute("c_pass");
		type=(String)session.getAttribute("c_type");
		System.out.println("E"+email1+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email1, pass, type);
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
		doGet(request, response);
		HttpSession session=request.getSession();
		String email1,pass,type;
		email1=(String)session.getAttribute("c_email");
		pass=(String)session.getAttribute("c_pass");
		type=(String)session.getAttribute("c_type");
		System.out.println("E"+email1+"pass"+pass+"type"+type);
		boolean b1=UserSession.getSessionAvaliable(email1, pass, type);
		if(!b1){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
			}else{
		//System.out.println("THE ID IS"+request.getParameter("reqest_id")+"Key"+request.getParameter("key"));
		
				
		boolean b=com.sendkey.CheckDAO.checkKey(Integer.parseInt(request.getParameter("reqest_id")),request.getParameter("key"));		
		System.out.println("THE ID IS"+request.getParameter("reqest_id")+"Key"+request.getParameter("key")+"Flag"+b);
		if(b){
	PrintWriter out=response.getWriter();
	//response.setContentType("text/html");
	out.println("<input type='hidden' name='file_id' value='"+request.getParameter("reqest_id")+"'>");
	out.println("<input type='hidden' name='key' value='"+request.getParameter("key")+"'>");
	response.sendRedirect(response.encodeURL("../../downloadfile")+"?filecontext="+request.getParameter("reqest_id")+"&my_type_file=creator&key="+request.getParameter("key")+"");

}else{
	response.sendRedirect("/Account/creator/secret_key.jsp?reqest_id="+request.getParameter("reqest_id")+"&key_status=Key Is Wrong");
	
	
}		
	
		}
	}
}
