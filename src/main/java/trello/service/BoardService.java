package trello.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import trello.dao.BoardDao;
import trello.dao.implementation.HibernateBoardDao;
import trello.model.Board;;

@Path("/boards")
public class BoardService {
	BoardDao boardDao = new HibernateBoardDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBoardByUser/{userId}")
	public Set<Board> getBoardByUser(@PathParam("userId") long id) {
		Set<Board> boards;
		boards = boardDao.getBoardsByUser(id);
		return boards;

	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBoard/{id}")
	public Board getBoard(@PathParam("id") long id) {
	Board board;
		board = boardDao.getBoard(id);
		return board;

	}
	
	
	
	@POST
	@Path("/createBoard")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBoard(Board board) {
		boardDao.saveBoard(board);
		return Response.status(201).entity("ok").build();

	}

	@PUT
	@Path("/updateBoard")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBoard(Board board) {
		boardDao.updateBoard(board);
		return Response.status(204).entity("ok").build();

	}

	@DELETE
	@Path("/deleteBoard/{id}")
	public Response deleteBoard(@PathParam("id") long id) {
		boardDao.deleteBoard(id);
		return Response.status(204).entity("ok").build();

	}
}
