package edu.self.model;

import java.util.ArrayList;

public class DTOQuestion {
	private int id;
	private String description;
	private int cuestionary;
	private ArrayList<DTOOption> options;
	
	public DTOQuestion(int id,String description,int cuestionary,ArrayList<DTOOption> options){
		this.id = id;
		this.description = description;
		this.cuestionary = cuestionary;
		this.options = options;
	}
	public int getId(){
		return this.id;
	}
	public String getDescription(){
		return this.description;
	}
	public int getCuestionary(){
		return this.cuestionary;
	}
	public ArrayList<DTOOption> getOptions(){
		return this.options;
	}
}
