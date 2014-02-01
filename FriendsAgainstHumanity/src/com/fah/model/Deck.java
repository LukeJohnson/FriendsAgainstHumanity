package com.fah.model;

import java.util.Date;

public class Deck {
	
	private int 	deckId;
	private String 	name;
	private String 	descr;
	private int 	creatorId;
	private Date 	created;
	
	
	public int getDeckId(){
		return deckId;
	}
	
	public void setDeckId(int deckId){
		this.deckId = deckId; 
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
