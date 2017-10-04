package com.forgot.pass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class checkEmail {
	public static boolean email(String email){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
		ResultSet rst=st.executeQuery("select email from regi where email='"+email+"'");
		if(rst.next()){
			if(rst.getString(1).equals(email)){
				
				return true;
			}else{
				return false;
				
			}
			
		}
		
			return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;}
		
	}
}
