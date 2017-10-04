package com.feed.replay;
import java.sql.*;
public class DeleteDAO {
		public static boolean DeleteFeed(int id){
				Connection con=com.db.Connection.MyConnection.getConnection();
				try {
					Statement st=con.createStatement();
					st.executeUpdate("delete from feed where id="+id);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
			return false;
		}
}
