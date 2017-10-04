package com.share.file;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.session.mgm.UserSession;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class sharefileServlet
 */
@WebServlet("/sharefileServlet")
public class sharefileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sharefileServlet() {
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
		
		boolean master=true;
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
		com.share.Bean.ShareBean b = null;
		boolean flag=true;//delete all record on data_des
		String s=null;		
		doGet(request, response);
		int obj_len=0;
		com.share.Bean.ShareBean obj=null;
		Enumeration<String> e=request.getParameterNames();
	
		while(e.hasMoreElements()){
			
		master=false;
		String name=e.nextElement();
		obj=new com.share.Bean.ShareBean();
		String value=request.getParameter(name);
		 session=request.getSession();
		s=(String)session.getAttribute(name);
		System.out.println("File ID"+s+"\t Key"+name+"\t  Values->>"+value);
			if(flag){
				try{
					java.sql.Connection con=com.db.Connection.MyConnection.getConnection();
					Statement st=con.createStatement();
					System.out.println("delete  from data_desc.file_des_"+s);
					st.executeUpdate("delete  from data_desc.file_des_"+s);
						flag=false;
						
					}catch(Exception e1){e1.printStackTrace();}
				
			}
		
		
		try {
			
			b=new com.share.Bean.ShareBean();
			b.setFile_name(s);
			b.setReg_id(Integer.parseInt(name));
			com.share.DAO.ShareDAO.saveshare(b);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj_len++;
	}
		if(master){
			try{
			java.sql.Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			System.out.println("delete  from data_desc.file_des_"+Integer.parseInt((String)session.getAttribute("master_id")));
			st.executeUpdate("delete  from data_desc.file_des_"+Integer.parseInt((String)session.getAttribute("master_id")));
				flag=false;
				
			}catch(Exception e1){e1.printStackTrace();}
		
			
			
		}
		
		System.out.println("Fuck"+session.getAttribute("master_id"));
	response.sendRedirect("/Account/creator/share_user.jsp?file_id="+session.getAttribute("master_id")+"&status_share=Shared Sucessfully");
	}
	}
}
