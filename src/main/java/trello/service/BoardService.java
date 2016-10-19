package trello.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import trello.dao.BoardDao;
import trello.dao.HibernateBoardDao;
import trello.model.Board;;

@Path("/boards")
public class BoardService {
	BoardDao boardDao = new HibernateBoardDao();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBoard/{userId}")
	public Board getBoardByUser(@PathParam("userId") long id) {
		Board board = boardDao.getBoard(id);
		return board;

	}

	@POST
	@Path("/createBoard")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBoard(Board board) {
		System.out.println("ddddd");
		boardDao.saveBoard(board);
		return Response.status(201).entity("result").build();

	}
}
