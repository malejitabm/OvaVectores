package edu.self.business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	
	public static String sha1(String password){
		String sha1Password = "";
		MessageDigest md = null;
		try {
	        md = MessageDigest.getInstance("SHA-1");
	    }
	    catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
		try{
			sha1Password = new String(md.digest(password.getBytes("UTF-8")));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return sha1Password;
	}
	/*
	public static String sha1(String password) throws NoSuchAlgorithmException, IOException{
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        FileInputStream fis = new FileInputStream(password);
        byte[] data = new byte[1024];
        int read = 0; 
        while ((read = fis.read(data)) != -1) {
            sha1.update(data, 0, read);
        };
        byte[] hashBytes = sha1.digest();
  
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashBytes.length; i++) {
          sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        String fileHash = sb.toString();
        return fileHash;
	}
	*/
}
