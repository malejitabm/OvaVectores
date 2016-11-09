package edu.self.model;

public class DTOUser {
	
	private String id;
	private String name;
	private String password;
	private int type;
	
	public DTOUser(String id,String name,String password,int type){
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}
	//Get's
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public int getType(){
		return this.type;
	}
	
}
