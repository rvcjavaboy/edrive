package com.sendkey.File;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;

/**
 * Servlet implementation class SendKey
 */
@WebServlet("/Account/creator/CreatorSendKey")
public class CreatorSendKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatorSendKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int file_id=Integer.parseInt(request.getParameter("req_id"));
		HttpSession session=request.getSession();
		String email1=(String)session.getAttribute("c_email");
		String pass=(String)session.getAttribute("c_pass");
		String type=(String)session.getAttribute("c_type");
		System.out.println("E"+email1+"pass"+pass+"type"+type);
		boolean b=UserSession.getSessionAvaliable(email1, pass, type);
		if(!b){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}else{
		String email=(String)session.getAttribute("c_email");
		com.send.FileKeyBean.FileKeyBean bean=new com.send.FileKeyBean.FileKeyBean();
		bean.setEmail(email);
		bean.setId(file_id);
		boolean mailSend=com.send.fileKeyDAO.SendFileSecretKeyDAO.sendFilekey(bean);;
		
		if(mailSend){
			response.sendRedirect("secret_key.jsp?reqest_id="+file_id);
			
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


