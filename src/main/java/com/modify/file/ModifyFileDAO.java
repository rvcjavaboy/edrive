package com.modify.file;
import java.io.InputStream;
import java.sql.*;
public class ModifyFileDAO {
	public static boolean setModifyFile(com.upload.Bean.FileBean b){
		try{
			InputStream encr=com.file.cipher.Encryption.getEncryption(b.getIn(),b.getKeys());
			Connection con=com.db.Connection.MyConnection.getConnection();
			PreparedStatement pr=con.prepareStatement("insert into modify_file (file_id,file_name,modifed,size,file_data,keyss,types,author) values(?,?,?,?,?,?,?,?)");
			pr.setInt(1, b.getId());
			pr.setString(2, b.getFilename());
			pr.setString(3, b.getModifed());
			pr.setString(4, b.getSize());
			pr.setBinaryStream(5,encr);
			pr.setString(6, b.getKeys());
			pr.setString(7, b.getTypes());
			pr.setString(8, b.getAuthor());
			
			pr.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
		
		
		return false;
	}
}
