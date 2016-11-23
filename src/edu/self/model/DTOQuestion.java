package edu.self.model;

import java.util.ArrayList;

public class DTOQuestion {
	private int id;
	private String description;
	private ArrayList<DTOOption> options;
	
	public DTOQuestion(int id,String description,ArrayList<DTOOption> options){
		this.id = id;
		this.description = description;
		this.options = options;
	}
	public int getId(){
		return this.id;
	}
	public String getDescription(){
		return this.description;
	}
	public ArrayList<DTOOption> getOptions(){
		return this.options;
	}
}
