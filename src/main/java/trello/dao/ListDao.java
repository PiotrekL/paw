package trello.dao;

import java.util.Set;

import trello.model.Board;
import trello.model.List;

public interface ListDao {
	public void saveList(List list);
	public void deleteList(Long listId);
	public void updateList(List list);
	
}
