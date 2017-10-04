package com.upload.DAO;
import java.io.InputStream;
import java.sql.*;
public class FileDAO {
		
		public static boolean fileUpload(com.upload.Bean.FileBean f) throws SQLException{
			Connection con=null;
				try{
					InputStream encr=com.file.cipher.Encryption.getEncryption(f.getIn(),f.getKeys());
					con=com.db.Connection.MyConnection.getConnection();
					con.setAutoCommit(false);
					PreparedStatement pr=con.prepareStatement("insert into files(name_file,author,modifed,size,file_data,keyss,types) values(?,?,?,?,?,?,?)");
					pr.setString(1, f.getFilename());
					pr.setString(2, f.getAuthor());
					pr.setString(3,"Not Modifed");
					pr.setString(4, f.getSize());
					pr.setBinaryStream(5,encr);
					pr.setString(6, f.getKeys());
					pr.setString(7, f.getTypes());
					pr.execute();
						int id=0;
						Statement st=con.createStatement();
						ResultSet rst=st.executeQuery("SELECT LAST_INSERT_ID()");
						if(rst.next()){
							System.out.println(rst.getInt(1));
							id=rst.getInt(1);
							
						}
						st.executeUpdate("create table data_desc.file_des_"+id+"(reg_id int)");
						st.executeUpdate("insert into master_files values("+id+",'"+f.getFilename()+"')");
						con.commit();
						return true;
					
					
					
					
					
				}catch(Exception e){
					con.rollback();
					e.printStackTrace();}
			
			
			return false;
		}
	
}
