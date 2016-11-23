package trello.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trello.dao.ColorsDao;
import trello.dao.implementation.HibernateColorsDao;
import trello.model.Color;
import trello.model.List;
@Path("/colors")
public class ColorService {
	ColorsDao colorsDao= new HibernateColorsDao();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Color> getBoardByUser() {
		Set<Color> colors;
		colors = colorsDao.getColors();
		return colors;

	}
}
