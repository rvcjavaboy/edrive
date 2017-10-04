package com.modify.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;

/**
 * Servlet implementation class modifyfile
 */
@WebServlet("/Account/writer/modifyfile")
public class modifyfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("w_email");
		String pass=(String)session.getAttribute("w_pass");
		String type=(String)session.getAttribute("w_type");
		System.out.println("E"+email+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email, pass, type);
		if(!b){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("w_email");
		String pass=(String)session.getAttribute("w_pass");
		String type=(String)session.getAttribute("w_type");
		System.out.println("E"+email+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email, pass, type);
		if(!b){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}else{
		doGet(request, response);
		String file_id=request.getParameter("reqest_id");
		String author=request.getParameter("author");
		String key=request.getParameter("key");
		boolean status=com.sendkey.CheckDAO.checkKey(Integer.parseInt(file_id), key);
		if(status){
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("<input type='hidden' value="+author+" name='author'>");
			out.println("<input type='hidden' value="+file_id+" name='reqest_id'>");
			RequestDispatcher re=request.getRequestDispatcher("modify_upload_file.jsp");
			re.forward(request, response);
		}else{
			
			response.sendRedirect("modify_secrte_key.jsp?reqest_id="+request.getParameter("reqest_id")+"&key_status=Key is Wrong&author="+author);
				
			
		}
		
	
	
	}
	}
}
