package com.bp.rd.ws.model;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ToDoModel {

	@XmlElement
	private int id;
	@XmlElement
	private String title;
	@XmlElement
	private String description;
	
	public ToDoModel() {}
	
	public ToDoModel(int id, String title, String description) {

		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
	    return "ToDoModel [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
	
	public static class IdComparator implements Comparator<ToDoModel> {
		private boolean isDecending;
		public IdComparator(boolean isDecending) {
			this.isDecending = isDecending;
        }
		@Override
	    public int compare(ToDoModel lhs, ToDoModel rhs) {
			if(lhs.getId() == rhs.getId())
				return 0;
			
			if(isDecending) {
				if(lhs.getId() > rhs.getId())
					return -1;
				else
					return 1;
			}
			else {
				if(lhs.getId() < rhs.getId())
					return -1;
				else
					return 1;
			}
	    }
	}
	
	public static class TitleComparator implements Comparator<ToDoModel> {
		private boolean isDecending;
		public TitleComparator(boolean isDecending) {
			this.isDecending = isDecending;
        }
		@Override
	    public int compare(ToDoModel lhs, ToDoModel rhs) {
			if(lhs.getTitle() == rhs.getTitle())
				return 0;
			
			if(isDecending)
				return rhs.getTitle().compareTo(lhs.getTitle());
			else 
				return lhs.getTitle().compareTo(rhs.getTitle());
	    }
	}
	
	public static class DescriptionComparator implements Comparator<ToDoModel> {
		private boolean isDecending;
		public DescriptionComparator(boolean isDecending) {
			this.isDecending = isDecending;
        }
		@Override
	    public int compare(ToDoModel lhs, ToDoModel rhs) {
			if(lhs.getDescription() == rhs.getDescription())
				return 0;
			
			if(isDecending)
				return rhs.getDescription().compareTo(lhs.getDescription());
			else 
				return lhs.getDescription().compareTo(rhs.getDescription());
	    }
	}
}