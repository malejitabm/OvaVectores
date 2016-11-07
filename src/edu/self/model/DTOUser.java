package edu.self.model;

public class DTOUser {
	
	private String username;
	private String email;
	private String password;
	
	public DTOUser(String username,String email,String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}
	//Get's
	public String getUsername(){
		return this.username;
	}
	public String getEmail(){
		return this.email;
	}
	public String getPassword(){
		return this.password;
	}
	
}
