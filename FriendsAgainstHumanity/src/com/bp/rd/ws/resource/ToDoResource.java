package com.bp.rd.ws.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.bp.rd.db.ToDoDAO;
import com.bp.rd.utils.QueryResult;
import com.bp.rd.utils.Range;
import com.bp.rd.utils.Sort;
import com.bp.rd.ws.model.ToDoModel;

@Path("/toDo")
public class ToDoResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postTodo(ToDoModel model) throws URISyntaxException {
		

		int id = ToDoDAO.insert(model);
		return Response.created(new URI(String.valueOf(id))).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getToDoList(@HeaderParam("Range") Range range, @QueryParam("sort") Sort sort) {

		QueryResult<ToDoModel> result = ToDoDAO.select(range, sort);
		ResponseBuilder response = Response.ok(result.getList());
		response.header("Content-Range", result.getContentRange());
		return response.build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getToDo(@PathParam("id") int id) {
		
		ToDoModel model = ToDoDAO.select(id);
		return Response.ok(model).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putToDo(@PathParam("id") int id, ToDoModel model) {

		if(ToDoDAO.update(id, model))
			return Response.ok().build();
		else
			return Response.notModified("Could no delete record").build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteToDo(@PathParam("id") int id) {

		if(ToDoDAO.delete(id))
			return Response.ok().build();
		else
			return Response.notModified("Could no delete record").build();
	}
}