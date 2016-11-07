package edu.self.model;

import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection implements Provider{
	private static java.sql.Connection instance = null;
	
	public static java.sql.Connection getConnection(){
		if(instance == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				instance = DriverManager.getConnection("jdbc:mysql://sandbox2.ufps.edu.co:3306/ufps_88", "ufps_88", "ufps_uy");
			}catch(ClassNotFoundException | SQLException e){
				System.out.println("Can't establish the connection: "+e);
			}
		}
		return instance;
	}
	
	public static boolean closeConnection(){
		if(instance != null){
			try{
				instance.close();
				instance = null;
				return true;
			}catch(SQLException e){
				System.err.println("Can't close the connection : "+e);
			}
		}
		return false;
	}
}
