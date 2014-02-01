package com.fah.model;


public class Card {

	private int    id;
	private String text;
	private boolean black;
	private int     creatorId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	
	public boolean isBlack() {
		return black;
	}
	
	public void setBlack(boolean black) {
		this.black = black;
	}
	
	
	
	
}
