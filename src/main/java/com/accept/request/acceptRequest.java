package com.accept.request;

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
 * Servlet implementation class acceptRequest
 */
@WebServlet("/acceptRequest")
public class acceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceptRequest() {
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
				HttpSession session=request.getSession();
				AdminSessionBean b1=new AdminSessionBean();
				b1.setUsername((String)session.getAttribute("emailadmin"));
				b1.setPass((String)session.getAttribute("passadmin"));
				boolean check=AdminSessionDAO.checkSession(b1);
				if(!check){
					response.sendRedirect("../../Admin.jsp?status=Please Login Again");
					
				}else{
				com.accept.Bean.UserRequestBean b=new com.accept.Bean.UserRequestBean();
				java.util.Enumeration<String>s=request.getParameterNames();
				while(s.hasMoreElements()){
				
				String key=s.nextElement();
				System.out.println("Key"+key);
				b.setId(Integer.parseInt(key));
				com.accept.DAO.UserRegisterRequestDAO.acceptRequest(b);
				
				
			}
		response.sendRedirect("/Account/admin/request.jsp?status_request=request Accepted Scuessfully");
	}
		}
}
