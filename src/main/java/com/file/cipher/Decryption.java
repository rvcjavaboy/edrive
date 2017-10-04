package com.file.cipher;

import java.io.OutputStream;
import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Decryption {

		public static CipherOutputStream getDecrytpion(OutputStream out,String Keymy) throws Exception{
			DESKeySpec dsk=new DESKeySpec(Keymy.getBytes());
            SecretKeyFactory fact=SecretKeyFactory.getInstance("DES");
            SecretKey skey=fact.generateSecret(dsk);
            Cipher ciph=Cipher.getInstance("DES");
            ciph.init(ciph.DECRYPT_MODE, skey);
            CipherOutputStream cout=new CipherOutputStream(out, ciph);
			
			return cout;
		}
}
