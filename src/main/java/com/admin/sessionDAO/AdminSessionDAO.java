package com.admin.sessionDAO;
import java.sql.*;
public class AdminSessionDAO {

		public static boolean checkSession(com.admin.sessionBean.AdminSessionBean a){
			try{
				Connection con=com.db.Connection.MyConnection.getConnection();
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select * from admin where username='"+a.getUsername()+"' AND pass='"+a.getPass()+"'");
				if(rst.next()){
					return true;
					
				}else{return false;}
				
			}catch(Exception e){e.printStackTrace();}
			
			
			return false;
		}
	
}
