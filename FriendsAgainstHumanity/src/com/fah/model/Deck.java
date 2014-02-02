package com.fah.model;

import java.util.Date;

public class Deck {
	
	private int 	id;
	private String 	name;
	private String 	descr;
	private int 	creatorId;
	private Date 	created;
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id; 
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public void setDescr(String descr){
		this.descr = descr;
	}
	
	public int getCreatorId(){
		return creatorId;
	}
	
	public void setCreatorId(int creatorId){
		this.creatorId = creatorId;
	}
	
	public Date getCreated(){
		return created;
	}

}
