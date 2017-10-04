package com.revoke.userDAO;
import java.sql.*;
public class RevokeUserDAO {
public static boolean deleteUser(com.user.revokeBean.RevokeUserBean r){
	try{
	Connection con=com.db.Connection.MyConnection.getConnection();
	Statement st=con.createStatement();
	st.executeUpdate("delete from regi where id="+r.getId());
	st.executeUpdate("delete from revoke_user where reg_id="+r.getId());
	}catch(Exception e){e.printStackTrace();}
	return false;
}
}
