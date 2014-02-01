package com.fah.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fah.service.CardService;
import com.fah.service.VoteService;

@ApplicationPath("/fah")
public class CardsApplication extends Application{

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(CardService.class);
		s.add(VoteService.class);
		s.add(JsonMessageBodyWriter.class);
		s.add(JsonMessageBodyReader.class);
		return s;
	}
	
}
