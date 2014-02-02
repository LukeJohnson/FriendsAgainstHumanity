package com.fah.model;

public class Vote {

	private int card_id;
	private int voter_id;
	private boolean up_vote;
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}
	public boolean isUp_vote() {
		return up_vote;
	}
	public void setUp_vote(boolean up_vote) {
		this.up_vote = up_vote;
	}
	
}
