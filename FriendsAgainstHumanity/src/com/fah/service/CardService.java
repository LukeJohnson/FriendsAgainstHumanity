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
import com.fah.model.Card;

@Path("/card")
public class CardService {
	
	private Connection getConnection(){
		return DatabaseUtil.getConnection();
	}
	
	private void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		System.out.println("List");
		ArrayList<Card> cards = new ArrayList<Card>();
		Connection conn = getConnection();
		QueryRunner query = new QueryRunner();
		ResultSetHandler<List<Card>> handler= new BeanListHandler<Card>(Card.class);
		try{
			List<Card> result = query.query(conn, "SELECT * FROM cards", handler);
			cards.addAll(result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeConnection(conn);
		ResponseBuilder resBuilder = Response.ok(cards);
		return resBuilder.build();
	}
	
	
	
	
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id){
		System.out.println("Get [id="+id+"]");
		Connection conn = getConnection();
		QueryRunner query = new QueryRunner();
		BeanHandler<Card> handler = new BeanHandler<Card>(Card.class);
		Card card = new Card();
		try{
			Card result= query.query(conn, "SELECT * FROM cards where id = ?", handler, id);
			if(result != null){
				card = result;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeConnection(conn);
		ResponseBuilder respBuilder = Response.ok(card);
		return respBuilder.build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Card card)throws URISyntaxException{
		System.out.println("insert [id="+card.getId()+"]");
		Connection conn = getConnection();
		QueryRunner query = new QueryRunner();
		int insertID = 0;
		try{
			insertID = query.update(conn, "insert into card(id, text, black, creatorId, deckId) values ?,?,?", card.getId(), card.getText(), card.isBlack(), card.getCreatorId(), card.getDeckId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeConnection(conn);
		ResponseBuilder respBuilder = Response.created(new URI(Integer.toString(insertID)));
		return respBuilder.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Card card)throws URISyntaxException{
		System.out.println("update [id="+card.getId()+"]");
		Connection conn = getConnection();
		QueryRunner query = new QueryRunner();
		int updateID = 0;
		try{
			updateID = query.update(conn, "update card set id=? text=? black=? creatorId=? deckId=?", card.getId(), card.getText(), card.isBlack(), card.getCreatorId(), card.getDeckId());
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeConnection(conn);
		ResponseBuilder respBuilder = Response.ok();
		return respBuilder.build();
	}
	
	
}
