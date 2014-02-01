package com.bp.rd.utils;


public class Range {
	
	private int low = 0;
	private int high = 0;

	public Range(int low, int high) {
		this.low = low;
		this.high = high;
	}
	
	public Range(String raw) {
		
		parse(raw);
	}
	
	private void parse(String raw) {
		
		if(raw == null || raw.length() < 9)
			return;
		
		String[] kv = raw.split("=");
		String[] lh = kv[1].split("-");
		
		try {
			this.low = Integer.parseInt(lh[0]);
			this.high = Integer.parseInt(lh[1]);
		}
		catch(NumberFormatException ex) { /*Swallow*/ }
	}
	
    public int getLow() {
    	return low;
    }
    public void setLow(int low) {
    	this.low = low;
    }
    public int getHigh() {
    	return high;
    }
    public void setHigh(int high) {
    	this.high = high;
    }
}