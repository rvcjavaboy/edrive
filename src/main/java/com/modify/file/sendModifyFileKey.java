package com.modify.file;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;

/**
 * Servlet implementation class sendModifyFileKey
 */
@WebServlet("/Account/writer/sendModifyFileKey")
public class sendModifyFileKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendModifyFileKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		int file_id=Integer.parseInt(request.getParameter("reqest_id"));
		String author=request.getParameter("author");
		session=request.getSession();
		 email=(String)session.getAttribute("w_email");
		com.send.FileKeyBean.FileKeyBean bean=new com.send.FileKeyBean.FileKeyBean();
		bean.setEmail(email);
		bean.setId(file_id);
		boolean mailSend=com.send.fileKeyDAO.SendFileSecretKeyDAO.sendFilekey(bean);;
		
		if(mailSend){
			response.sendRedirect("modify_secrte_key.jsp?reqest_id="+file_id+"&author="+author);
			
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
