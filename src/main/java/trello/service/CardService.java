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

import trello.dao.CardDao;

import trello.dao.implementation.HibernateCardDao;

import trello.model.Card;
@Path("/cards")
public class CardService {

	CardDao cardDao = new HibernateCardDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCard/{listId}")
	public Set<Card> getCard(@PathParam("listId") long id) {
		Set<Card> cards;
		cards = cardDao.getCards(id);
		return cards;

	}

	@POST
	@Path("/createCard")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCard(Card card) {
		Long id=cardDao.saveCard(card);
		return Response.status(201).entity(id.toString()).build();

	}

	@PUT
	@Path("/updateCard")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCard(Card card) {
		cardDao.updateCard(card);
		return Response.status(204).entity("ok").build();

	}

	@DELETE
	@Path("/deleteCard/{id}")
	public Response deleteCard(@PathParam("id") long id) {
		cardDao.deleteCard(id);
		return Response.status(204).entity("ok").build();

	}
	
}
