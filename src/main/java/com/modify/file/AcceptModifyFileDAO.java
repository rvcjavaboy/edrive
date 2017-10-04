package com.modify.file;

import java.sql.*;;

public class AcceptModifyFileDAO {
	public static boolean updateModifyFile(int modifed){
		try{
			int flag=0;
			com.upload.Bean.FileBean f=new com.upload.Bean.FileBean();
			Connection con=com.db.Connection.MyConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select * from modify_file where id="+modifed);
		if(rst.next()){
			f.setId(rst.getInt(2));
			f.setFilename(rst.getString(3));
			f.setModifed(rst.getString(4));
			f.setSize(rst.getString(5));
			f.setIn(rst.getBinaryStream(6));
			f.setKeys(rst.getString(7));
			f.setTypes(rst.getString(8));
			f.setAuthor(rst.getString(9));
				
				PreparedStatement pr=con.prepareStatement("update files set name_file=?,author=?,modifed=?,size=?,file_data=?,keyss=?,types=? where id=?");
				pr.setString(1, f.getFilename());
				pr.setString(2, f.getAuthor());
				pr.setString(3, f.getModifed());
				pr.setString(4, f.getSize());
				pr.setBinaryStream(5, f.getIn());
				pr.setString(6, f.getKeys());
				pr.setString(7, f.getTypes());
				pr.setInt(8, f.getId());
				
				pr.execute();
				flag=1;
				
			}
		
		
		else{
			
			return false;
		}if(flag==1){
			st.executeUpdate("delete from modify_file where id="+modifed);
			return true;
			
		}else{
			return false;
			
		}
			
		}catch(Exception e){e.printStackTrace();}	
		
		
		
		
		return false;
	}
}
