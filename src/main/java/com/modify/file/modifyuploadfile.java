package com.modify.file;

import java.io.IOException;
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
 * Servlet implementation class modifyuploadfile
 */
@WebServlet("/Account/writer/modifyuploadfile")
@MultipartConfig(maxFileSize = 999999999)
public class modifyuploadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyuploadfile() {
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
		}

	}
/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		

		doGet(request, response);
		 session=request.getSession();
		System.out.println(request.getParameter("reqest_id"));
		com.upload.Bean.FileBean fbean=new com.upload.Bean.FileBean();
		fbean.setId(Integer.parseInt(request.getParameter("reqest_id")));
		Part file=request.getPart("file");
		fbean.setAuthor(request.getParameter("author"));
		fbean.setModifed((String)session.getAttribute("w_email"));
		fbean.setFilename(getFileName(file));
		fbean.setSize(""+file.getSize());
		fbean.setTypes(file.getContentType());
		fbean.setKeys(com.keygenrator.Key.getKey());
		fbean.setIn(file.getInputStream());
		
		boolean b1=com.modify.file.ModifyFileDAO.setModifyFile(fbean);
		if(b1){
			response.sendRedirect("modify_upload_file.jsp?modify_file_status=file upload sucessfully wait for accept&reqest_id="+request.getParameter("reqest_id")+"&author="+request.getParameter("author"));
			
		}else{
			response.sendRedirect("modify_upload_file.jsp?modify_file_status=file upload failed&reqest_id="+request.getParameter("reqest_id")+"&author="+request.getParameter("author"));
			
			
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
