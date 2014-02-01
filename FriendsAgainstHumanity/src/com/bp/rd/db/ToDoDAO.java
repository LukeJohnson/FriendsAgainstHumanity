package com.bp.rd.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bp.rd.utils.QueryResult;
import com.bp.rd.utils.Range;
import com.bp.rd.utils.Sort;
import com.bp.rd.ws.model.ToDoModel;

public enum ToDoDAO {

	instance;

	private List<ToDoModel> contentProvider = new ArrayList<ToDoModel>();

	private ToDoDAO() {

		ToDoModel toDo;

		toDo = new ToDoModel(1, "Teach the toaster to feel love", "The usual approach.");
		contentProvider.add(toDo);
		toDo = new ToDoModel(2, "Remove Excess Hair", "Remember to buy gas!");
		contentProvider.add(toDo);
		toDo = new ToDoModel(3, "Cross Off To Do List Item", "Use @DELETE");
		contentProvider.add(toDo);
		for(int i = 4; i <= 200; i++) {
			toDo = new ToDoModel(i, "Filler", "Lets fill this list up with some crap");
			contentProvider.add(toDo);
		}
	}

	public List<ToDoModel> getModel() {

		return contentProvider;
	}
	
	public static int nextId() {
		int id = 0;
		for(ToDoModel model : ToDoDAO.instance.getModel())
			if(model.getId() > id)
				id = model.getId();
		
		return id + 1;
	}
	
	public static int insert(ToDoModel model) {
		
		int id = nextId();
		model.setId(id);
		instance.getModel().add(model);
		return id;
	}
	
	public static QueryResult<ToDoModel> select(Range range, Sort sort) {
		
		List<ToDoModel> sortedModel = instance.getModel();
		if(sort != null) {
			if(sort.getColumn().equals("id"))
				Collections.sort(sortedModel, new ToDoModel.IdComparator(sort.isDecending()));
			else if(sort.getColumn().equals("title"))
				Collections.sort(sortedModel, new ToDoModel.TitleComparator(sort.isDecending()));
			else if(sort.getColumn().equals("description"))
				Collections.sort(sortedModel, new ToDoModel.DescriptionComparator(sort.isDecending()));
		}
		
		if(range == null)
			range = new Range(0, sortedModel.size()-1);
		
		List<ToDoModel> list = new ArrayList<ToDoModel>();
		for(int i = range.getLow(); i <= range.getHigh() && i < sortedModel.size(); i++) 
			list.add(sortedModel.get(i));
		
		return new QueryResult<ToDoModel>(list, range, sort, sortedModel.size());
	}
	
	public static ToDoModel select(int id) {
		
		return instance.getModel().get(id);
	}
	
	public static boolean update(int id, ToDoModel model) {

		for(ToDoModel m : instance.getModel()) {
			if(m.getId() == id) {
				instance.getModel().add(id, model);
				return true;
			}
		}
		return false;
	}
	
	public static boolean delete(int id) {
		
		for(ToDoModel model : instance.getModel()) {
			if(model.getId() == id) {
				instance.getModel().remove(model);
				return true;
			}
		}
		return false;
	}
}