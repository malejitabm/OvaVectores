package edu.self.model;

public class DTOOption {
	private int id;
	private String description;
	private int question;
	
	public DTOOption(int id,String description,int question){
		this.id = id;
		this.description = description;
		this.question = question;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getDescription(){
		return this.description;
	}
	public int getQuestion(){
		return this.question;
	}
}
