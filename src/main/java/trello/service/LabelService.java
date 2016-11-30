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

import trello.dao.LabelDao;
import trello.dao.implementation.HibernateLabelDao;
import trello.model.Label;
import trello.model.List;

@Path("/labels")
public class LabelService {
	LabelDao labelDao= new HibernateLabelDao();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getLabels/{cardId}")
	public Set<Label> getLabels(@PathParam("cardId") long id) {
		Set<Label> labels;
		labels = labelDao.getLabel(id);
		return labels;

	}
	
	
	@POST
	@Path("/createLabel")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createList(Label label) {
		Long id=labelDao.saveLabel(label);
		return Response.status(201).entity(id.toString()).build();

	}



	@DELETE
	@Path("/deleteLabel/{id}")
	public Response deleteList(@PathParam("id") long id) {
		labelDao.deleteLabel(id);
		return Response.status(204).entity("ok").build();

	}
}

