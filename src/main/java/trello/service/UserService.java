package trello.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import trello.dao.UserDao;
import trello.dao.implementation.HibernateUserDao;
import trello.model.Board;
import trello.model.User;

@Path("/users")
public class UserService {
	UserDao userDao = new HibernateUserDao();

	@GET
	@Path("{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("login") String login) {
		UserDao userDao = new HibernateUserDao();
		return userDao.getUser(login);
	}

	@POST
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBoard(User user) {
		userDao.saveUser(user);
		return Response.status(201).entity("ok").build();

	}
}
