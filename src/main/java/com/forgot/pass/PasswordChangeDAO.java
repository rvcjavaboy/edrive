package com.forgot.pass;

import java.sql.*;;

public class PasswordChangeDAO {
	public static boolean passChange(String email,String pass){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("update regi set pass="+pass+" where email='"+email+"'");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;}
		
	}
}
