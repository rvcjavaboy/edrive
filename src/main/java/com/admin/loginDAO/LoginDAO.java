package com.admin.loginDAO;

import java.sql.*;
public class LoginDAO {
	public static boolean getAccessAdmin(com.admin.loginBean.LoginBean b){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select * from admin where username='"+b.getName()+"' AND pass='"+b.getPass()+"'");
			if(rst.next()){
				if(rst.getString(1).equals(b.getName())&&rst.getString(2).equals(b.getPass())){
					return true;
					
				}
				
			}else{return false;}
			
		}catch(Exception e){
			
			e.printStackTrace();
		return false;
		}
		return false;
	}
}
