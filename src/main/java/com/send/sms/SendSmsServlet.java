package com.send.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendSmsServlet
 */
@WebServlet("/SendSmsServlet")
public class SendSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public static String status="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSmsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> e=request.getParameterNames();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
	
		
		com.send.sms.SendSMS.sms=request.getParameter("msg");
		com.send.sms.SendSMS.number=request.getParameter("number");
		com.send.sms.SendSMS test = new com.send.sms.SendSMS();
		test.sendMessage();
		response.sendRedirect("/other/admin/sendSms.jsp?success=Message Send Suessfully");
	
	}

}
