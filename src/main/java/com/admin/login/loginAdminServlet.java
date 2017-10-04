package com.admin.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginAdminServlet
 */
@WebServlet("/loginAdminServlet")
public class loginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAdminServlet() {
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
		String name=request.getParameter("email");
		String pass=request.getParameter("pass");
		System.out.println("ADMIn");
		com.admin.loginBean.LoginBean b=new com.admin.loginBean.LoginBean();
		b.setName(name);
		b.setPass(pass);
		boolean status=com.admin.loginDAO.LoginDAO.getAccessAdmin(b);
		if(status){
			HttpSession session=request.getSession();
			session.setAttribute("emailadmin",b.getName());
			session.setAttribute("passadmin",b.getPass());
			
			response.sendRedirect("Account/admin/home.jsp");
			
		}else{
			
			response.sendRedirect("Admin.jsp?status=login Falied");
			
		}
	
	}

}
