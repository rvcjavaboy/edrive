package com.share.DAO;

import java.sql.*;

public class ShareDAO {
	public static boolean saveshare(com.share.Bean.ShareBean b) throws SQLException{
		Statement st = null;
			try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			st=con.createStatement();
					
			String query="insert into data_desc.file_des_"+b.getFile_name()+" values("+b.getReg_id()+")";
			System.out.println(query);
			st.executeUpdate(query);
			return true;
			}catch(Exception e){
			st.executeUpdate("delete  from data_desc.file_des_"+b.getFile_name()+" where reg_id="+b.getReg_id()+"");	
			e.printStackTrace();
				
			}
		
		
		return false;
	}
}
