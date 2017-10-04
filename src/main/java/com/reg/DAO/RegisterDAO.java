package com.reg.DAO;
import java.sql.*;
public class RegisterDAO {
	
		public static boolean regDB(com.reg.Bean.Register r){
				try{
					Connection con=com.db.Connection.MyConnection.getConnection();
					PreparedStatement pr=con.prepareStatement("insert into regi(name,email,pass,cpass,phone,type,a_status,admin_auth) values(?,?,?,?,?,?,0,0)");
					pr.setString(1, r.getName());
					pr.setString(2, r.getEmail());
					pr.setString(3, r.getPass());
					pr.setString(4, r.getCpass());
					pr.setString(5, r.getPhone());
					pr.setString(6, r.getType());
					boolean b= pr.execute();
					return true;
					
				}catch(Exception e){e.printStackTrace();}
			
			
			
			
			return false;
		}
		
		public static int getID(com.reg.Bean.Register r){
			try{
				Connection con=com.db.Connection.MyConnection.getConnection();
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select id from regi where email='"+r.getEmail()+"'");
				if(rst.next()){
					
					return rst.getInt(1);
				}
				
				
			}catch(Exception e){e.printStackTrace();}
			return 0;
		}
}
