package com.accept.DAO;

import java.sql.*;

public class UserRegisterRequestDAO {
	public static boolean acceptRequest(com.accept.Bean.UserRequestBean u){
		
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("update regi set admin_auth=1 where id="+u.getId());
			
			
			
		}catch(Exception e){
			e.printStackTrace();}

		return false;
	}
}
