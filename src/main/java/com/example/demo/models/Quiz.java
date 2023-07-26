package com.example.demo.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;



@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ID;
	String type;
	String diffLevel;
	@ManyToMany
	List<Question> questions;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDiffLevel() {
		return diffLevel;
	}
	public void setDiffLevel(String diffLevel) {
		this.diffLevel = diffLevel;
	}
	public List<Question> getList() {
		return questions;
	}
	public void setList(List<Question> list) {
		this.questions = list;
	}
	
	

}
