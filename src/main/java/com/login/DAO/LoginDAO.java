package com.login.DAO;

import java.sql.*;

public class LoginDAO {

		public static boolean getAccess(com.login.Bean.Login l){
			
			try{
				Connection con=com.db.Connection.MyConnection.getConnection();
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select email,pass from regi where email='"+l.getName()+"'AND pass='"+l.getPass()+"'AND type='"+l.getType()+"'AND a_status='1' AND admin_auth='1'");
				if(rst.next()){
					
					if(rst.getString(1).equals(l.getName())&&rst.getString(2).equals(l.getPass())){
						System.out.println("Hel");
						return true;
						
					}
				}
			}catch(Exception e){e.printStackTrace();}
			
			
			return false;
			
		}
	
}
