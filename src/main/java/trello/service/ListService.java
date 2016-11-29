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
import trello.dao.ListDao;
import trello.dao.implementation.HibernateBoardDao;
import trello.dao.implementation.HibernateListDao;
import trello.model.Board;
import trello.model.List;

@Path("/lists")
public class ListService {
	ListDao listDao = new HibernateListDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getLists/{boardId}")
	public Set<List> getLists(@PathParam("boardId") long id) {
		Set<List> lists;
		lists = listDao.getLists(id);
		return lists;

	}

	@POST
	@Path("/createList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createList(List list) {
		listDao.saveList(list);
		return Response.status(201).entity("ok").build();

	}

	@PUT
	@Path("/updateList")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateList(List list) {
		listDao.updateList(list);
		return Response.status(204).entity("ok").build();

	}

	@DELETE
	@Path("/deleteList/{id}")
	public Response deleteList(@PathParam("id") long id) {
		listDao.deleteList(id);
		return Response.status(204).entity("ok").build();

	}
}
