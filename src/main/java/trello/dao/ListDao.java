package trello.dao;

import trello.model.Board;
import trello.model.List;

public interface ListDao {
	public void saveList(List list, Long boardId);
	
}
