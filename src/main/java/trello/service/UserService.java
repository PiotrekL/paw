package trello.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
import trello.controller.LoginController;
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
	public Response createUser(@FormParam("login") String login, @FormParam("password") String password){
		User user= new User();
		user.setLogin(login);
		user.setPassword(password);
		Long id=userDao.saveUser(user);
		return Response.status(201).entity(id.toString()).build();

	}
	
	

	@POST
	@Path("/login")
	public Response checkUser(@FormParam("login") String login, @FormParam("password") String password) {
		LoginController lc= new LoginController();
		Boolean result=lc.authenticateUser(login, password);
		return Response.status(201).entity(result.toString()).build();
		

	}
}
