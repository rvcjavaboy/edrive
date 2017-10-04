package com.feed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feed
 */
@WebServlet("/feed")
public class feed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feed() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String msg=request.getParameter("msg");
		
				com.feed.Bean.FeedBean f=new com.feed.Bean.FeedBean();
				f.setName(name);
				f.setEmail(email);
				f.setMsg(msg);
				boolean feed=new com.feed.DAO.FeedDAO().saveFeed(f);
				if(feed){
					response.sendRedirect("index.jsp?feedback=Feedback Suceessfully Send");
					
					
				}else{
					
					response.sendRedirect("index.jsp?feedback=Feedback Sending Failed");
					
				}
		
	}

}
