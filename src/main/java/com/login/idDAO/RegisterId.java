package com.login.idDAO;
import java.sql.*;
public class RegisterId {
	public static int getRegisterId(String email,String pass,String type){
		Connection con=com.db.Connection.MyConnection.getConnection();
		try {
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select id from regi where email='"+email+"' AND pass='"+pass+"' AND type='"+type+"'");
			if(rst.next()){
				return rst.getInt(1);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		return  0;
		}
		
		
		
		return 0;
	}
}
