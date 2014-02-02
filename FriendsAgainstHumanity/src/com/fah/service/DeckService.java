package com.fah.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fah.db.DatabaseUtil;
import com.fah.model.Deck;

@Path("/deck")
public class DeckService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		System.out.println("List");
		ArrayList<Deck> decks = new ArrayList<Deck>();
		Connection conn = DatabaseUtil.getConnection();
		QueryRunner query = new QueryRunner();
		ResultSetHandler<List<Deck>> handler = new BeanListHandler<Deck>(Deck.class);
		try{
			List<Deck> result = query.query(conn, "SELECT * FROM decks", handler);
			decks.addAll(result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuilder = Response.ok(decks);
		return respBuilder.build();
	}
	
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id){
		System.out.println("Get [id="+id+"]");
		Connection conn = DatabaseUtil.getConnection();
		QueryRunner query = new QueryRunner();
		BeanHandler<Deck> handler = new BeanHandler<Deck>(Deck.class);
		Deck deck = new Deck();
		try{
			Deck result = query.query(conn, "SELECT * FROM decks where id = ?", handler, id);
			if(result != null){
				deck = result;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuilder = Response.ok(deck);
		return respBuilder.build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Deck deck)throws URISyntaxException{
		System.out.println("insert [id="+deck.getId()+"]");
		Connection conn = DatabaseUtil.getConnection();
		QueryRunner query = new QueryRunner();
		int insertID = 0;
		try{
			insertID = query.update(conn, "insert into decks(id, name, descr, creatorId) values ?,?,?,?", deck.getId(), deck.getName(), deck.getDescr(), deck.getCreatorId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuilder = Response.created(new URI(Integer.toString(insertID)));
		return respBuilder.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Deck deck){
		System.out.println("update [id="+deck.getId()+"]");
		Connection conn = DatabaseUtil.getConnection();
		QueryRunner query = new QueryRunner();
		int updateID = 0;
		try{
			updateID = query.update(conn, "update decks set id=?, name=?, descr=?, creatorId=?", deck.getId(), deck.getName(), deck.getDescr(), deck.getCreatorId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuilder = Response.ok(deck);
		return respBuilder.build();
	}
	
}