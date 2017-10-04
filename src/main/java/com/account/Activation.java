package com.account;
import java.sql.*;

public class Activation {
	public static boolean setkey(int id,String key){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			PreparedStatement pr=con.prepareStatement("insert into ver_table values(?,?)");
			pr.setInt(1, id);
			pr.setString(2, key);
			pr.execute();
			return true;
		}catch(Exception e)
		{
			}
		return false;
	
	}
	
	public static boolean getkey(int id,String key){
		try{
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from ver_table where id="+id+" AND  key1="+key+"'";
			System.out.println("Query"+query);
			ResultSet rst=st.executeQuery(query);
			if(rst.next()){
				
				query="update regi set a_status='1' where id="+id+"";
				System.out.println("Query"+query);
				st.executeUpdate(query);
				return true;
			}
		}catch(Exception e)
		{e.printStackTrace();
			}
		return false;
	
	}
		
		
	}
	

