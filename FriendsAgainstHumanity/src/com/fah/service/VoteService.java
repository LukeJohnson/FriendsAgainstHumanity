package com.fah.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/vote")
public class VoteService {

	@GET
	public Response retrieve(){
		ResponseBuilder respBuilder = Response.ok("These are not the droids your looking for!");
		return respBuilder.build();
	}
	
	@PUT
	@Path("{cardId}")
	public Response castVote(boolean upVote)throws URISyntaxException{
		Connection conn 
		ResponseBuilder respBuiltder = Response.created(new URI("Vote Casted"));
		return respBuiltder.build();
	}
	
} 
