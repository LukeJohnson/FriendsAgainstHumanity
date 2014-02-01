package com.bp.rd.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.bp.rd.ws.resource.ToDoResource;

@ApplicationPath("/data")
public class RestfulDojoApplication extends Application {

	public Set<Class<?>> getClasses() {

		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(ToDoResource.class);
		s.add(JsonMessageBodyWriter.class);
		s.add(JsonMessageBodyReader.class);
		
		return s;
	}
}