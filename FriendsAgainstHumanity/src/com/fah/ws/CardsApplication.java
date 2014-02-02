package com.fah.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.fah.service.CardService;
import com.fah.service.VoteService;
import com.fah.service.DeckService;

@ApplicationPath("/fah")
public class CardsApplication extends Application{

	@GET
	public String info(){
		return "Welcome to Friends Against Humanity Services!";
	}
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(CardsApplication.class);
		s.add(CardService.class);
		s.add(VoteService.class);
		s.add(DeckService.class);
		s.add(JsonMessageBodyWriter.class);
		s.add(JsonMessageBodyReader.class);
		return s;
	}
	
}
