package edu.self.model;

import java.util.ArrayList;

public class DTOCuestionary {
	private int id;
	private String name;
	private String description;
	private int subtopic;
	private ArrayList<DTOQuestion> questions;
	
	public DTOCuestionary(int id,String name,String description,int subtopic,ArrayList<DTOQuestion> questions){
		this.id = id;
		this.name = name;
		this.description = description;
		this.subtopic = subtopic;
		this.questions = questions;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}
	public int getSubTopic(){
		return this.subtopic;
	}
	public ArrayList<DTOQuestion> getQuestions(){
		return this.questions;
	}
}
