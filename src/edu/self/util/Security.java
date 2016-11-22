package edu.self.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	public static String getMd5(String chars){
		String encrypted = "";
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(chars.getBytes(), 0, chars.length());
            encrypted = new BigInteger(1, m.digest()).toString(16);
            System.out.println("MD5: "+encrypted);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Can't encrypt the data: "+ex);
        }
        return encrypted;
	}
}
