package com.keygenrator;
import java.security.SecureRandom;
import java.math.BigInteger;

public class Key {
	public static String getKey(){
		
		SecureRandom random = new SecureRandom();

		
		    return new BigInteger(130, random).toString(32);
	}
}
