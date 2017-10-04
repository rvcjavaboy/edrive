package com.upload.file;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.account.session.mgm.UserSession;

/**
 * Servlet implementation class uploadFile
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/uploadFile", 
				"/Account/creator/uploadFile"
		})
@MultipartConfig(maxFileSize = 999999999)
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email,pass,type;
		HttpSession session=request.getSession();
			email=(String)session.getAttribute("c_email");
			pass=(String)session.getAttribute("c_pass");
			type=(String)session.getAttribute("c_type");
			System.out.println("E"+email+"pass"+pass+"type"+type);
			boolean b=UserSession.getSessionAvaliable(email, pass, type);
			if(!b){
				response.sendRedirect("../../login.jsp?status=Please Login Again");
			}else{
			
			Part file=request.getPart("file");
			System.out.println(""+file.getContentType());
			System.out.println(""+file.getSize());
			System.out.println(getFileName(file));
			com.upload.Bean.FileBean filebean=new com.upload.Bean.FileBean();
			filebean.setFilename(getFileName(file));
			filebean.setAuthor(email);
			filebean.setSize(""+file.getSize());
			filebean.setTypes(file.getContentType());
			filebean.setAuthor(email);
			filebean.setKeys(com.keygenrator.Key.getKey());
			InputStream in=null;
			//apply encryption algo
			filebean.setIn(file.getInputStream());
			
			
			boolean b1 = false;
			try {
				b1 = com.upload.DAO.FileDAO.fileUpload(filebean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b1){
			//	RequestDispatcher rd=request.getRequestDispatcher("/Account/creator/upload_file.jsp?file_status=File uploaded succesfully");
				//rd.forward(request, response);
				response.sendRedirect("/Account/creator/upload_file.jsp?file_status=File uploaded succesfully");
				
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("/Account/creator/upload_file.jsp?file_status=File uploading Fail");
				rd.forward(request, response);
			
				response.sendRedirect("/Account/creator/upload_file.jsp?file_status=File uploading Fail");
				
				//
			}
			
	}
			
		
		
		
		
		
	}public static String getFileName(Part filePart)
	{
	    String header = filePart.getHeader("content-disposition");
	    for(String headerPart : header.split(";"))
	    {
	        if(headerPart.trim().startsWith("filename"))
	        {
	            return headerPart.substring(headerPart.indexOf('=') + 1).trim()
	                             .replace("\"", "");
	        }
	    }
	    return null;
	}

}
