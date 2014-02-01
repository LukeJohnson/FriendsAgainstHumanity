package com.fah.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fah.db.DatabaseUtil;
import com.fah.model.Card;
import com.sun.jersey.api.core.ParentRef;

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
	public Collection<Card> list(){
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
		return cards;
	}
	
	
	
	
	
	@GET
	@Path("{id}")
	public Card get(@PathParam("id") int id){
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
		return card;
	}
	
	
	
}
