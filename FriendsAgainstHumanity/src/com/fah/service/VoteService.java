package com.fah.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.dbutils.QueryRunner;

import com.fah.db.DatabaseUtil;
import com.fah.model.Vote;

@Path("/vote")
public class VoteService {

	@GET
	public Response retrieve(){
		ResponseBuilder respBuilder = Response.ok("These are not the droids your looking for!");
		return respBuilder.build();
	}
	
	@PUT
	@Path("{cardId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response castVote(Vote vote)throws URISyntaxException{
		Connection conn = DatabaseUtil.getConnection();
		DatabaseUtil.closeConnection(conn);
		QueryRunner query = new QueryRunner();
		int updateId = -1;
		try{
			updateId = query.update(conn, "insert into votes(card_id, up_vote, voter_id) values ?,  ?, ?",vote.getCard_id(), vote.isUp_vote(), vote.getVoter_id());
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuiltder = Response.created(new URI(Integer.toString(updateId)));
		return respBuiltder.build();
	}
	
} 