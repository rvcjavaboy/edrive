package com.db.Connection;
import java.sql.*;
public class MyConnection {
	static Connection con=null;
	public static Connection getConnection(){
		
		try{
			if(con==null){
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://127.11.94.2:3306/test","adminlJE8t8S","IG_3zQp-FqcK");
				
				return con;
				
			}else{return con;}
			
		}catch(Exception e){System.out.println("DB"+e);}
		return con;
	} 
public static Connection getConnectionMysql(){
		
		try{
			if(con==null){
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://127.11.94.2:3306/test","adminlJE8t8S","IG_3zQp-FqcK");
						
			return con;
				
			}else{return con;}
			
		}catch(Exception e){System.out.println("DB"+e);}
		return con;
	} 
}
