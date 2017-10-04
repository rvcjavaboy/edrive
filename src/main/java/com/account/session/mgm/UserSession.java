package com.account.session.mgm;
import java.sql.*;
public class UserSession {
	
	public static boolean getSessionAvaliable(String name,String pass,String type){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from regi where email='"+name+"' AND pass='"+pass+"' AND type='"+type+"' AND  a_status=1";
			System.out.println(query);
			ResultSet rst=st.executeQuery(query);
			if(rst.next()){
				
				return true;
			}else{
				return false;
				
			}
			
			
		}catch(Exception e){e.printStackTrace();}
		
		
		
		
		
		return false;
	}
}
