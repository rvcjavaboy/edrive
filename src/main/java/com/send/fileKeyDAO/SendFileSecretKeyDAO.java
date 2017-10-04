package com.send.fileKeyDAO;
import java.sql.*;
public class SendFileSecretKeyDAO {

		public static boolean sendFilekey(com.send.FileKeyBean.FileKeyBean f){
			Connection con=com.db.Connection.MyConnection.getConnection();
			try {
				String key="",name;
			
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select keyss,name_file from files where id="+f.getId());
				if(rst.next()){
					key=rst.getString(1);
					name=rst.getString(2);
			return 	com.email.EmailSend.sendMailFileKey(key, f.getEmail(),name);
				}
				
			
				
				
				
				
				
				
				
				
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return false;
		}		public static boolean sendModifyFilekey(com.send.FileKeyBean.FileKeyBean f){
			Connection con=com.db.Connection.MyConnection.getConnection();
			try {
				String key="",name;
			
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select keyss,file_name from modify_file where id="+f.getId());
				if(rst.next()){
					key=rst.getString(1);
					name=rst.getString(2);
			return 	com.email.EmailSend.sendMailFileKey(key, f.getEmail(),name);
				}
				
			
				
				
				
				
				
				
				
				
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return false;
		}
	
}
