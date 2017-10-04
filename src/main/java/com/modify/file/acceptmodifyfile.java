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
 * Servlet implementation class acceptmodifyfile
 */
@WebServlet("/Account/creator/acceptmodifyfile")
public class acceptmodifyfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceptmodifyfile() {
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
		boolean b1=UserSession.getSessionAvaliable(email, pass, type);
		if(!b1){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
		}else{
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		boolean b=com.modify.file.AcceptModifyFileDAO.updateModifyFile(Integer.parseInt(request.getParameter("modifed_file_id")));
		
			if(b){
				response.sendRedirect("modifed_file_list.jsp?status_modifed=File Accepted Successfully");
				
			}else{
				response.sendRedirect("modifed_file_list.jsp?status_modifed=File Accepted Falied");
							
				
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
