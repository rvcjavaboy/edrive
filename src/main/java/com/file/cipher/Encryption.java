package com.file.cipher;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
public class Encryption {
	public static InputStream getEncryption(InputStream in,String key){
		try {
		DESKeySpec dsk=new DESKeySpec(key.getBytes());
		SecretKeyFactory fact=SecretKeyFactory.getInstance("DES");
		SecretKey secretkey=fact.generateSecret(dsk);
		Cipher ciph=Cipher.getInstance("DES");
		ciph.init(Cipher.ENCRYPT_MODE, secretkey);
		CipherInputStream fin=new CipherInputStream(in, ciph);
		return fin;
			
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	}
}
