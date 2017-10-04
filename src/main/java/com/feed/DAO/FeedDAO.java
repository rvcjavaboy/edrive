package com.feed.DAO;

import com.feed.Bean.FeedBean;
import java.sql.*;

public class FeedDAO {


	public boolean saveFeed(FeedBean f){
		try{
		Connection con=com.db.Connection.MyConnection.getConnection();
		Statement st=con.createStatement();
		PreparedStatement pr=con.prepareStatement("insert into  feed(name,email,msg,status) values(?,?,?,0)");
		pr.setString(1, f.getName());
		pr.setString(2,f.getEmail());
		pr.setString(3,f.getMsg());
		System.out.println(f.getMsg());
		pr.execute();
		return true;
		}catch(Exception e){
			
			e.printStackTrace();

		return false;
		}	
		
	}

}
