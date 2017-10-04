package com.sendkey;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckDAO {
public static boolean checkKey(int id,String key){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select keyss from files where id="+id+" AND keyss='"+key+"'");
			if(rst.next()){
				return true;
				
			}
		}catch(Exception e){
			
			System.out.println("KEY MATCH"+e);
		}
	
	
	
	
	return false;
}public static boolean checkModifyKey(int id,String key){
	try{
		Connection con=com.db.Connection.MyConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rst=st.executeQuery("select keyss from modify_file where id="+id+" AND keyss='"+key+"'");
		if(rst.next()){
			return true;
			
		}
	}catch(Exception e){
		
		System.out.println("KEY MATCH"+e);
	}




return false;
}
}
