package com.bp.rd.utils;

import java.util.List;


public class QueryResult<T> {
	
	private List<T> list;
	private Range range;
	private Sort sort;
	private int numFound;
	
    public QueryResult(List<T> list, Range range, Sort sort, int numFound) {

	    this.list = list;
	    this.range = range;
	    this.sort = sort;
	    this.numFound = numFound;
    }
    
    public String getContentRange() {
    	return "items " + range.getLow() + "-" + range.getHigh() + "/" + getNumFound();
    }
    
	public List<T> getList() {
    	return list;
    }
    public void setList(List<T> list) {
    	this.list = list;
    }
    public Range getRange() {
    	return range;
    }
    public void setRange(Range range) {
    	this.range = range;
    }
    public Sort getSort() {
    	return sort;
    }
    public void setSort(Sort sort) {
    	this.sort = sort;
    }
	public int getNumFound() {
    	return numFound;
    }
    public void setNumFound(int numFound) {
    	this.numFound = numFound;
    }
}