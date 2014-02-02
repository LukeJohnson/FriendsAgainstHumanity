package com.fah.model;

import java.util.Date;


public class Card {

	private int    id;
	private String text;
	private boolean black;
	private int     creatorId;
	private int		deckId;
	private Date 	created;
	private int		upvotes;
	private int		downvotes;
	
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
	
	public int getDeckId() {
		return deckId;
	}
	
	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}
	
	public Date getCreated(){
		return created;
	}
	
	public int getUpvotes(){
		return upvotes;
	}
	
	public void setUpvotes(int upvotes){
		this.upvotes = upvotes;
	}
	
	public int getDownvotes(){
		return downvotes;
	}
	
	public void setDownvotes(int downvotes){
		this.downvotes = downvotes;
	}
}
