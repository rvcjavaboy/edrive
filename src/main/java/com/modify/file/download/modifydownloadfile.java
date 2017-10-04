package com.modify.file.download;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.CipherOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class modifydownloadfile
 */
@WebServlet("/Account/creator/modifydownloadfile")
public class modifydownloadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifydownloadfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean ses=false;
		HttpSession session=request.getSession();
		System.out.println("FILE ID"+request.getParameter("file_id"));
		if(request.getParameter("my_type_file").equals("creator")){
			String name=(String)session.getAttribute("c_email");
			String pass=(String)session.getAttribute("c_pass");
			String type=(String)session.getAttribute("c_type");
			ses=com.account.session.mgm.UserSession.getSessionAvaliable(name, pass, type);
			
		}
		if(!ses){
			response.sendRedirect("../../login.jsp?status=Please Login Again");
			
		}else{
		try{
			
			String fileName;
			InputStream in=null;
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rst =st.executeQuery("select * from modify_file where id="+Integer.parseInt(request.getParameter("filecontext"))+" AND keyss='"+request.getParameter("key")+"'");
			if(rst.next()){
				fileName=rst.getString(3);
				in=rst.getBinaryStream(6);
				int filelength=in.available();
				ServletContext context=getServletContext();
				String mimetype=context.getMimeType(fileName);
				if(mimetype==null){
					mimetype="application/octet-stream";
					
				} 
				response.setContentType(mimetype);
                response.setContentLength(filelength);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue);
                OutputStream outStream = response.getOutputStream();
               CipherOutputStream cout=com.file.cipher.Decryption.getDecrytpion(outStream, request.getParameter("key"));
               
               int i=in.read();
               while(i!=-1){
                	cout.write(i);
                	i=in.read();
                	
                }
                cout.close();
                outStream.close();
                in.close();
                
                
                
                
                
                
				
			}
			
			
			
		
	
	}catch(Exception e){e.printStackTrace();}
		}
		System.out.println("ID"+request.getParameter("filecontext"));
		System.out.println("key"+request.getParameter("key"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
