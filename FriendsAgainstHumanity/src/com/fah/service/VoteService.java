package com.fah.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.dbutils.QueryRunner;

import com.fah.db.DatabaseUtil;

@Path("/vote")
public class VoteService {

	@GET
	public Response retrieve(){
		ResponseBuilder respBuilder = Response.ok("These are not the droids your looking for!");
		return respBuilder.build();
	}
	
	
	/*
	 * TO-DO: Create Vote Constructor to parse the URL string
	 *  - Send cardId from Path
	 * 	- up/down should be in URL
	 *  - vote_id will be returned from queryVote to updateVoteId
	 */
	@POST
	@Path("{cardId}/{vote}")
	public Response castVote(@PathParam("cardId") int id, @PathParam("vote") int vote)throws URISyntaxException{
		Connection conn = DatabaseUtil.getConnection();
		QueryRunner queryVote = new QueryRunner();
		QueryRunner queryCard = new QueryRunner();
		int updateVoteId = -1;
		int updateVoteCount = -1;
		try{
			updateVoteId = queryVote.update(conn, "INSERT INTO votes(card_id, up_vote, voter_id) VALUES (?, ?, ?)",id, vote, 1);
			if(vote == 1){
				updateVoteCount = queryCard.update(conn, "UPDATE cards SET upvotes = upvotes + 1 WHERE id=?", id);
				System.out.println("upvote cardID: " + id);
			}else if(vote == 0){
				updateVoteCount = queryCard.update(conn, "UPDATE cards SET downvotes = downvotes + 1 WHERE id=?", id);
				System.out.println("downvote cardID: " + id);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DatabaseUtil.closeConnection(conn);
		ResponseBuilder respBuilder = Response.created(new URI(Integer.toString(updateVoteId)));
		return respBuilder.build();
	}
	
	
} 
