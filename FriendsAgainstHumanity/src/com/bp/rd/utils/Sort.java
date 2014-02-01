package com.bp.rd.utils;


public class Sort {
	
	private boolean isDecending = false;
	private String column = "id";
	
	public Sort(String raw) {

		parse(raw);
	}
	
	private void parse(String raw) {
		
		if(raw == null || raw.length() < 2)
			return;
		
		setDecending(raw.startsWith("-"));
		setColumn(raw.substring(1));
	}

    public boolean isDecending() {
    	return isDecending;
    }
    public void setDecending(boolean isDecending) {
    	this.isDecending = isDecending;
    }
    public String getColumn() {
    	return column;
    }
    public void setColumn(String column) {
    	this.column = column;
    }
}
