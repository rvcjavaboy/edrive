package com.revoke.DAO;

import java.sql.*;

public class RevokeDAO {
	public static boolean sendRevokeRequest(com.revoke.Bean.RevokeBean r){
		try{
			int i=0;
	Connection con=com.db.Connection.MyConnection.getConnection();
	Statement st=con.createStatement();
		
			st.executeUpdate("insert into revoke_user values("+r.getReg_id()+",'"+r.getSender()+"')");
			
		
		
		}catch(Exception e){e.printStackTrace();}
		return false;
	}
}
